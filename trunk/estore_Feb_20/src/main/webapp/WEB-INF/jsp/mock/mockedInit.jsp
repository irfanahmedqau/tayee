<%@page import="com.bleum.canton.mock.MockedCategoryVO"%>
<%@page import="com.bleum.canton.mock.MockedProductVO"%>
<%@page import="com.bleum.canton.mock.MockedBeanRegistrationTable"%>
<%@page import="java.util.*"%>

<%
	//create the instances of MockedCategoryVO
	MockedCategoryVO cat01 = new MockedCategoryVO();	
	cat01.setRootCategory(true);
	cat01.setParentCategory(true);
	cat01.setLeafCategory(false);
	cat01.setCategoryId("cat01");
	cat01.setCategoryName("手机数码");
	
	MockedCategoryVO cat011 = new MockedCategoryVO();
	cat011.setRootCategory(false);
	cat011.setParentCategory(true);
	cat011.setLeafCategory(false);
	cat011.setCategoryId("cat011");
	cat011.setCategoryName("电脑产品");
	cat011.addParentCategory(cat01);
	
	MockedCategoryVO cat012 = new MockedCategoryVO();
	cat012.setRootCategory(false);
	cat012.setParentCategory(true);
	cat012.setLeafCategory(false);
	cat012.setCategoryId("cat012");
	cat012.setCategoryName("数码影像");
	cat012.addParentCategory(cat01);
	
	MockedCategoryVO cat0111 = new MockedCategoryVO();
	cat0111.setRootCategory(false);
	cat0111.setParentCategory(false);
	cat0111.setLeafCategory(true);
	cat0111.setCategoryId("cat0111");
	cat0111.setCategoryName("笔记本电脑");
	cat0111.addParentCategory(cat011);
	
	MockedCategoryVO cat0112 = new MockedCategoryVO();
	cat0112.setRootCategory(false);
	cat0112.setParentCategory(false);
	cat0112.setLeafCategory(true);
	cat0112.setCategoryId("cat0112");
	cat0112.setCategoryName("台式电脑");
	cat0112.addParentCategory(cat011);
	
	MockedCategoryVO cat0113 = new MockedCategoryVO();
	cat0113.setRootCategory(false);
	cat0113.setParentCategory(false);
	cat0113.setLeafCategory(true);
	cat0113.setCategoryId("cat0113");
	cat0113.setCategoryName("电脑配件");
	cat0113.addParentCategory(cat011);
	
	MockedCategoryVO cat0121 = new MockedCategoryVO();
	cat0121.setRootCategory(false);
	cat0121.setParentCategory(false);
	cat0121.setLeafCategory(true);
	cat0121.setCategoryId("cat0121");
	cat0121.setCategoryName("单反相机");
	cat0121.addParentCategory(cat012);
	
	MockedCategoryVO cat0122 = new MockedCategoryVO();
	cat0122.setRootCategory(false);
	cat0122.setParentCategory(false);
	cat0122.setLeafCategory(true);
	cat0122.setCategoryId("cat0122");
	cat0122.setCategoryName("摄像机");
	cat0122.addParentCategory(cat012);
	
	MockedCategoryVO cat0123 = new MockedCategoryVO();
	cat0123.setRootCategory(false);
	cat0123.setParentCategory(false);
	cat0123.setLeafCategory(true);
	cat0123.setCategoryId("cat0123");
	cat0123.setCategoryName("望远镜");
	cat0123.addParentCategory(cat012);
	

	
	//create the instances of MockedCategoryVO
	
	MockedCategoryVO cat02 = new MockedCategoryVO();
	cat02.setRootCategory(true);
	cat02.setParentCategory(true);
	cat02.setLeafCategory(false);
	cat02.setCategoryId("cat02");
	cat02.setCategoryName("文体用品");
		
	MockedCategoryVO cat021 = new MockedCategoryVO();
	cat021.setRootCategory(false);
	cat021.setParentCategory(true);
	cat021.setLeafCategory(false);
	cat021.setCategoryId("cat021");
	cat021.setCategoryName("体育用品");
	cat021.addParentCategory(cat02);
		
	MockedCategoryVO cat022 = new MockedCategoryVO();
	cat022.setRootCategory(false);
	cat022.setParentCategory(true);
	cat022.setLeafCategory(false);
	cat022.setCategoryId("cat022");
	cat022.setCategoryName("玩具系列");
	cat022.addParentCategory(cat02);
		
	MockedCategoryVO cat0211 = new MockedCategoryVO();
	cat0211.setRootCategory(false);
	cat0211.setParentCategory(false);
	cat0211.setLeafCategory(true);
	cat0211.setCategoryId("cat0211");
	cat0211.setCategoryName("球类用品");
	cat0211.addParentCategory(cat021);
		
	MockedCategoryVO cat0212 = new MockedCategoryVO();
	cat0212.setRootCategory(false);
	cat0212.setParentCategory(false);
	cat0212.setLeafCategory(true);
	cat0212.setCategoryId("cat0212");
	cat0212.setCategoryName("户外用品");
	cat0212.addParentCategory(cat021);
		
	MockedCategoryVO cat0213 = new MockedCategoryVO();
	cat0213.setRootCategory(false);
	cat0213.setParentCategory(false);
	cat0213.setLeafCategory(true);
	cat0213.setCategoryId("cat0213");
	cat0213.setCategoryName("健身器材");
	cat0213.addParentCategory(cat021);
		
	MockedCategoryVO cat0214 = new MockedCategoryVO();
	cat0214.setRootCategory(false);
	cat0214.setParentCategory(false);
	cat0214.setLeafCategory(true);
	cat0214.setCategoryId("cat0214");
	cat0214.setCategoryName("运动背包");
	cat0214.addParentCategory(cat021);
		
	MockedCategoryVO cat0215 = new MockedCategoryVO();
	cat0215.setRootCategory(false);
	cat0215.setParentCategory(false);
	cat0215.setLeafCategory(true);
	cat0215.setCategoryId("cat0215");
	cat0215.setCategoryName("自行车配件");
	cat0215.addParentCategory(cat021);
		
	MockedCategoryVO cat0221 = new MockedCategoryVO();
	cat0221.setRootCategory(false);
	cat0221.setParentCategory(false);
	cat0221.setLeafCategory(true);
	cat0221.setCategoryId("cat0221");
	cat0221.setCategoryName("汽车玩具");
	cat0221.addParentCategory(cat022);
		
	MockedCategoryVO cat0222 = new MockedCategoryVO();
	cat0222.setRootCategory(false);
	cat0222.setParentCategory(false);
	cat0222.setLeafCategory(true);
	cat0222.setCategoryId("cat0222");
	cat0222.setCategoryName("儿童自行车");
	cat0222.addParentCategory(cat022);
		
	MockedCategoryVO cat0223 = new MockedCategoryVO();
	cat0223.setRootCategory(false);
	cat0223.setParentCategory(false);
	cat0223.setLeafCategory(true);
	cat0223.setCategoryId("cat0223");
	cat0223.setCategoryName("益智玩具");
	cat0223.addParentCategory(cat022);
		
	MockedCategoryVO cat0224 = new MockedCategoryVO();
	cat0224.setRootCategory(false);
	cat0224.setParentCategory(false);
	cat0224.setLeafCategory(true);
	cat0224.setCategoryId("cat0224");
	cat0224.setCategoryName("毛绒玩具");
	cat0224.addParentCategory(cat022);
		
	MockedCategoryVO cat0225 = new MockedCategoryVO();
	cat0225.setRootCategory(false);
	cat0225.setParentCategory(false);
	cat0225.setLeafCategory(true);
	cat0225.setCategoryId("cat0225");
	cat0225.setCategoryName("娃娃玩具");
	cat0225.addParentCategory(cat022);
		
	MockedCategoryVO cat0226 = new MockedCategoryVO();
	cat0226.setRootCategory(false);
	cat0226.setParentCategory(false);
	cat0226.setLeafCategory(true);
	cat0226.setCategoryId("cat0226");
	cat0226.setCategoryName("学步玩具");
	cat0226.addParentCategory(cat022);
		
	MockedCategoryVO cat0227 = new MockedCategoryVO();
	cat0227.setRootCategory(false);
	cat0227.setParentCategory(false);
	cat0227.setLeafCategory(true);
	cat0227.setCategoryId("cat0227");
	cat0227.setCategoryName("游戏机");
	cat0227.addParentCategory(cat022);
		
		

	//construct the relationship between the categories
	
		
		
		
		
	MockedProductVO prod0227_1= new MockedProductVO();
	prod0227_1.setProductId("prod0227_1");
	prod0227_1.setProductName("苏泊尔蒸煮多用锅ST28R1");
	prod0227_1.setPrice(129);
	prod0227_1.setThumbnailImgPath("cateSports_img1.jpg");
	prod0227_1.setCategoryVO(cat0227);
	
	MockedProductVO prod0227_2= new MockedProductVO();
	prod0227_2.setProductId("prod0227_2");
	prod0227_2.setProductName("巧媳妇银刃旗舰六件套T-388-6");
	prod0227_2.setPrice(229);
	prod0227_2.setThumbnailImgPath("cateSports_img2.jpg");
	prod0227_2.setCategoryVO(cat0227);
	
	MockedProductVO prod0227_3= new MockedProductVO();
	prod0227_3.setProductId("prod0227_3");
	prod0227_3.setProductName("雕牌高效洗洁精2000克");
	prod0227_3.setPrice(15);
	prod0227_3.setThumbnailImgPath("cateSports_img3.jpg");
	prod0227_3.setCategoryVO(cat0227);
	
	MockedProductVO prod0227_4= new MockedProductVO();
	prod0227_4.setProductId("prod0227_4");
	prod0227_4.setProductName("索尼纯平彩电43寸");
	prod0227_4.setPrice(3129);
	prod0227_4.setThumbnailImgPath("cateDigital_img1.jpg");
	prod0227_4.setCategoryVO(cat0227);
	
	
		
		
		
		
		
		
		
	
	//a bean registeration table
	MockedBeanRegistrationTable beanRegistrationTable = new MockedBeanRegistrationTable();
	beanRegistrationTable.addEntry("cat01",cat01);
	beanRegistrationTable.addEntry("cat011",cat011);
	beanRegistrationTable.addEntry("cat012",cat012);
	beanRegistrationTable.addEntry("cat0111",cat0111);
	beanRegistrationTable.addEntry("cat0112",cat0112);
	beanRegistrationTable.addEntry("cat0113",cat0113);
	beanRegistrationTable.addEntry("cat0121",cat0121);
	beanRegistrationTable.addEntry("cat0122",cat0122);
	beanRegistrationTable.addEntry("cat0123",cat0123);
	
	beanRegistrationTable.addEntry("cat02",cat02);
	beanRegistrationTable.addEntry("cat021",cat021);
	beanRegistrationTable.addEntry("cat022",cat022);
	beanRegistrationTable.addEntry("cat0211",cat0211);
	beanRegistrationTable.addEntry("cat0212",cat0212);
	beanRegistrationTable.addEntry("cat0213",cat0213);
	beanRegistrationTable.addEntry("cat0214",cat0214);
	beanRegistrationTable.addEntry("cat0215",cat0215);
	beanRegistrationTable.addEntry("cat0221",cat0221);
	beanRegistrationTable.addEntry("cat0222",cat0222);
	beanRegistrationTable.addEntry("cat0223",cat0223);
	beanRegistrationTable.addEntry("cat0224",cat0224);
	beanRegistrationTable.addEntry("cat0225",cat0225);
	beanRegistrationTable.addEntry("cat0226",cat0226);
	beanRegistrationTable.addEntry("cat0227",cat0227);
	
	//set the registration table as global
	application.setAttribute("beanRegistrationTable",beanRegistrationTable);
	
	
	
	
	
	
	
	

	
%>




