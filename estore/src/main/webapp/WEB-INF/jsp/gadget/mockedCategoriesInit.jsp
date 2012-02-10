<%@page import="com.bleum.canton.homepage.gln.mock.MockedCategoryVO " %>
<%@page import="java.util.*" %>

<%
	//create the instances of MockedCategoryVO
	MockedCategoryVO digital = new MockedCategoryVO();
	digital.setParentCategory(true);
	digital.setCategoryId("cat01");
	digital.setCategoryName("手机数码");
	
	MockedCategoryVO computer = new MockedCategoryVO();
	computer.setParentCategory(true);
	computer.setCategoryId("cat011");
	computer.setCategoryName("电脑产品");
	
	MockedCategoryVO camera = new MockedCategoryVO();
	camera.setParentCategory(true);
	camera.setCategoryId("cat012");
	camera.setCategoryName("数码影像");
	
	MockedCategoryVO laptop = new MockedCategoryVO();
	laptop.setParentCategory(false);
	laptop.setCategoryId("cat0111");
	laptop.setCategoryName("笔记本电脑");
	
	MockedCategoryVO desktop = new MockedCategoryVO();
	desktop.setParentCategory(false);
	desktop.setCategoryId("cat0112");
	desktop.setCategoryName("台式电脑");
	
	MockedCategoryVO facility = new MockedCategoryVO();
	facility.setParentCategory(false);
	facility.setCategoryId("cat0113");
	facility.setCategoryName("电脑配件");
	
	MockedCategoryVO slrcamera = new MockedCategoryVO();
	slrcamera.setParentCategory(false);
	slrcamera.setCategoryId("cat0121");
	slrcamera.setCategoryName("单反相机");
	
	MockedCategoryVO telecamera = new MockedCategoryVO();
	telecamera.setParentCategory(false);
	telecamera.setCategoryId("cat0122");
	telecamera.setCategoryName("摄像机");
	
	MockedCategoryVO telescope = new MockedCategoryVO();
	telescope.setParentCategory(false);
	telescope.setCategoryId("cat0123");
	telescope.setCategoryName("望远镜");
	

	//construct the relationship between the categories
	digital.addSubCategory("cat011");
	digital.addSubCategory("cat012");
	computer.addSubCategory("cat0111");
	computer.addSubCategory("cat0112");
	computer.addSubCategory("cat0113");
	camera.addSubCategory("cat0121");
	camera.addSubCategory("cat0122");
	camera.addSubCategory("cat0123");
	
	//a bean registeration table
	Map<String ,MockedCategoryVO> beanRegistrationTable = new HashMap<String,MockedCategoryVO> ();
	beanRegistrationTable.put("cat01",digital);
	beanRegistrationTable.put("cat011",computer);
	beanRegistrationTable.put("cat012",camera);
	beanRegistrationTable.put("cat0111",laptop);
	beanRegistrationTable.put("cat0112",desktop);
	beanRegistrationTable.put("cat0113",facility);
	beanRegistrationTable.put("cat0121",slrcamera);
	beanRegistrationTable.put("cat0122",telecamera);
	beanRegistrationTable.put("cat0123",telescope);
	
	//set the registration table as global
	application.setAttribute("beanRegistrationTable",beanRegistrationTable);

	
%>




