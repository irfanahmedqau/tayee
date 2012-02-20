<%--
  This page build one root category in the left navigation bar
  
    
  @author: charles.wang
  mailto: charles.wang@bleum.com
   
--%>
<%@page import="com.bleum.canton.mock.MockedCategoryVO"%>
<%@page import="com.bleum.canton.mock.MockedBeanRegistrationTable" %>
<%@page import="com.bleum.canton.itempage.service.*" %>
<%@page import="com.bleum.canton.itempage.entity.*" %>
<%@page import="java.util.*"%>

<%-- get the values from the included page --%>



<c:set var="rootCategoryId" value="${param.rootCategoryId }" />
<%
    String rootCategoryId = (String) (pageContext.getAttribute("rootCategoryId"));
    
	IItempageService itempageService = (IItempageService) request.getAttribute("itempageService");

    //get all the related information by given the bean name
    Category rootCategory= (Category)itempageService.getCategoryByID(rootCategoryId);
    //out.println(rootCategoryVO.getCategoryId());

    String rootCategoryName = rootCategory.getCategoryName();

   
    //get subCategories
    ArrayList<String> subCategoryIds = (ArrayList<String>) itempageService.getChildCategoryIDs(rootCategoryId);
    
   
%>





<li><a href="#">
				
				<span><%=rootCategoryName %></span>
			</a>
			
			<!-- 
			<div class="dropDown">
				<div class="col">
					<div class="border-L">
						<h3 class="cat_header">
							<a href="#" title="休闲零食"> <%=rootCategoryName %></a>
						</h3>
						<p>
							<a href="#" title="薯片"> 薯片</a>
						</p>
						<p>
							<a href="#" title="肉干"> 肉干</a>
						</p>
						<p>
							<a href="#" title="坚果"> 坚果</a>
						</p>
						<p>
							<a href="#" title="小食"> 小食</a>
						</p>
						<p>
							<a href="#" title="蜜饯"> 蜜饯</a>
						</p>
						<p>
							<a href="#" title="海味零食"> 海味零食</a>
						</p>
						<p class="lastList">
							<a href="#" title="果冻/布丁"> 果冻/布丁</a>
						</p>
						<div class="clear"></div>
					</div>
					<div class="border-L">
						<h3 class="cat_header">
							<dsp:a href="${ctx}/navigation/gadgets/category.jsp">
								<dsp:param name="categoryNavIds" value="1" />
								<dsp:param name="itemId" value="13" />
                冲饮茗茶
            </dsp:a>
						</h3>
						<p>
							<a href="#" title="成人奶粉"> 成人奶粉</a>
						</p>
						<p>
							<a href="#" title="麦片"> 麦片</a>
						</p>
						<p>
							<dsp:a href="${ctx}/navigation/gadgets/category.jsp">
								<dsp:param name="categoryNavIds" value="1" />
								<dsp:param name="itemId" value="17" />
                茶叶茶包
            </dsp:a>
						</p>
						<p>
							<a href="#" title="咖啡"> 咖啡</a>
						</p>
						<p>
							<a href="#" title="蜂蜜"> 蜂蜜</a>
						</p>
						<p>
							<a href="#" title="奶茶"> 奶茶</a>
						</p>
						<div class="clear"></div>
					</div>
				</div>
				<div class="col">
					<div class="border-L">
						<p class="lastList">
							<a href="#" title="果珍"> 果珍</a>
						</p>
						<div class="clear"></div>
					</div>
					<div class="border-L">
						<h3 class="cat_header">
							<dsp:a href="${ctx}/navigation/gadgets/category.jsp">
								<dsp:param name="categoryNavIds" value="1" />
								<dsp:param name="itemId" value="48" />
                   酒  品
            </dsp:a>
						</h3>
						<p>
							<dsp:a href="${ctx}/navigation/gadgets/category.jsp">
								<dsp:param name="categoryNavIds" value="1" />
								<dsp:param name="itemId" value="49" />
                烈酒
            </dsp:a>
						</p>
						<p>
							<dsp:a href="${ctx}/navigation/gadgets/category.jsp">
								<dsp:param name="categoryNavIds" value="1" />
								<dsp:param name="itemId" value="50" />
                葡萄酒
            </dsp:a>
						</p>
						<p>
							<a href="#" title="啤酒"> 啤酒</a>
						</p>
						<p class="lastList">
							<a href="#" title="香槟"> 香槟</a>
						</p>
						<div class="clear"></div>
					</div>
					<div class="border-L">
						<h3 class="cat_header">
							<a href="#" title="乳制品"> 乳制品</a>
						</h3>
						<p>
							<a href="#" title="进口乳制品"> 进口乳制品</a>
						</p>
						<p class="lastList">
							<a href="#" title="国产乳制品"> 国产乳制品</a>
						</p>
						<div class="clear"></div>
					</div>
					<div class="border-L">
						<h3 class="cat_header">
							<a href="#" title="饮料/水"> 饮料/水</a>
						</h3>
						<p>
							<a href="#" title="茶饮料"> 茶饮料</a>
						</p>
						<p>
							<a href="#" title="水"> 水</a>
						</p>
						<p>
							<a href="#" title="碳酸饮料"> 碳酸饮料</a>
						</p>
						<p>
							<a href="#" title="凉茶"> 凉茶</a>
						</p>
						<p>
							<a href="#" title="果汁"> 果汁</a>
						</p>
						<div class="clear"></div>
					</div>
				</div>
				<div class="col">
					<div class="border-L">
						<p>
							<a href="#" title="咖啡饮料"> 咖啡饮料</a>
						</p>
						<p>
							<a href="#" title="运动/健康饮料"> 运动/健康饮料</a>
						</p>
						<p class="lastList">
							<a href="#" title="醋饮料"> 醋饮料</a>
						</p>
						<div class="clear"></div>
					</div>
					<div class="border-L">
						<h3 class="cat_header">
							<a href="#" title="粮油米面"> 粮油米面</a>
						</h3>
						<p>
							<a href="#" title="米"> 米</a>
						</p>
						<p>
							<a href="#" title="油"> 油</a>
						</p>
						<p>
							<a href="#" title="方便面"> 方便面</a>
						</p>
						<p>
							<a href="#" title="五谷杂粮"> 五谷杂粮</a>
						</p>
						<p>
							<a href="#" title="面粉"> 面粉</a>
						</p>
						<p>
							<a href="#" title="橄榄油"> 橄榄油</a>
						</p>
						<p class="lastList">
							<a href="#" title="面条/粉丝"> 面条/粉丝</a>
						</p>
						<div class="clear"></div>
					</div>
					<div class="border-L">
						<h3 class="cat_header">
							<a href="#" title="饼  干"> 饼 干</a>
						</h3>
						<p>
							<a href="#" title="曲奇饼干"> 曲奇饼干</a>
						</p>
						<p>
							<a href="#" title="苏打饼干"> 苏打饼干</a>
						</p>
						<div class="clear"></div>
					</div>
					<div class="border-L">
						<h3 class="cat_header">
							<a href="#"> <b>查看全部</b>
							</a>
						</h3>
						<div class="clear"></div>
					</div>
				</div>
			</div>
			
			
			-->
			
			</li>