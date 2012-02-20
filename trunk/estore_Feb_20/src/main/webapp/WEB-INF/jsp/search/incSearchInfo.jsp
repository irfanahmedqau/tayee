<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="searchRInfo">
    <h1>
        <fmt:message key="canton.search.message.count">
            <fmt:param>${searchResult.query.keyWord}</fmt:param>
            <fmt:param>${searchResult.totalCount}</fmt:param>
        </fmt:message>
        <span style="display:none">您是不是在找“<a href=""><b>数码手机</b></a>”、“<a href=""><b>数码电视</b></a>”</span>
    </h1>
    <div class="keyWord" style="display:none">
        <ul>
          <li class="title">相关搜索：</li>
          <li><a href="">数码照相机</a></li>
          <li>|</li>
          <li><a href="">数码MP3</a></li>
          <li>|</li>
          <li><a href="">数码MP3</a></li>
          <li>|</li>
          <li><a href="">数码MP3</a></li>
          <li>|</li>
          <li><a href="">数码MP3</a></li>
          <li>|</li>
          <li><a href="">数码MP3</a></li>
        </ul>
    </div>
</div>