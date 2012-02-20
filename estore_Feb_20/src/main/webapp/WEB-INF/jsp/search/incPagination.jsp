<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="pagePanel">
    <ul class="paginationBar">
        <c:url var="baseSearchUrl" value="/search?">
            <c:param name="keyWord">${searchResult.query.keyWord}</c:param>
             <c:param name="pageSize">${searchResult.pagination.pageSize}</c:param>
        </c:url>
        <c:if test="${searchResult.query.page > 1}">
            <li>
                <a href="${baseSearchUrl}page=${searchResult.query.page - 1}"><fmt:message key="canton.search.pagination.lastPage"/></a>
            </li>
        </c:if>
        
        <c:if test="${searchResult.pagination.prePaginationGroupBegin > 0}">
            <li>
                <a href="${baseSearchUrl}page=${searchResult.pagination.prePaginationGroupBegin}">...</a>
            </li>
        </c:if> 
        
        <c:forEach begin="${searchResult.pagination.begin}" end="${searchResult.pagination.end}" step="1" var="pageIndex">
            <li>
                <c:choose>
                    <c:when test="${searchResult.query.page != pageIndex}">
                        <a href="${baseSearchUrl}page=${pageIndex}">
                            ${pageIndex}
                        </a>
                    </c:when>
                    <c:otherwise>
                        <span class="current">${pageIndex}</span>
                    </c:otherwise>
                </c:choose>
            </li>
        </c:forEach> 
        
        <c:if test="${searchResult.pagination.nextPaginationGroupBegin > 0}">
            <li>
                <a href="${baseSearchUrl}page=${searchResult.pagination.nextPaginationGroupBegin}">...</a>
            </li>
        </c:if>
        
        <c:if test="${searchResult.query.page < searchResult.pagination.pages}">
            <li>
                <a href="${baseSearchUrl}page=${searchResult.query.page + 1}"><fmt:message key="canton.search.pagination.nextPage"/></a>
            </li>
        </c:if>
</ul>                                               
</div>
<div class="gotPage">
    <a href="${baseSearchUrl}page=" url="${baseSearchUrl}page=" title="searchNumber"></a>
    <input type="text" value="${searchResult.pagination.currentPage}" pages="${searchResult.pagination.pages}" name="" maxlength="30"/>
</div>
