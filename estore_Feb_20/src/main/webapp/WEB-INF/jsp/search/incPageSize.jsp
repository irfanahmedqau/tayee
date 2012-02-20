<%@ page language="java" pageEncoding="UTF-8"%>
<div class="orderAmount">
    <c:url var="baseSearchUrl" value="/search?">
    <c:param name="keyWord">${searchResult.query.keyWord}</c:param>
    </c:url>
    <div style="float:left;">显示数量：</div>
    <div style="float:left;">
        <ul>
          <c:set var="pageSizeArray" value="12,24,36"/>
          <c:forEach items="${pageSizeArray}" var="vPageSize">
            <c:choose>
                <c:when test="${searchResult.pagination.pageSize eq vPageSize}">
                     <li class="icon_${vPageSize}"><a href="javascript:void(0);" class="cur" title="vPageSize"></a></li>
                </c:when>
                <c:otherwise>
                    <li class="icon_${vPageSize}"><a href="${baseSearchUrl}pageSize=${vPageSize}" class="" title="${vPageSize}"></a></li>
                </c:otherwise>
            </c:choose>
          </c:forEach>
        </ul>
    </div>
</div>