<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.sql.*"%>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="en"><head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Parking Spots Availability">
    <meta name="description" content="">
    <title>Parking Availability</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
<link rel="stylesheet" href="Parking-Availability.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script>
    <meta name="generator" content="Nicepage 5.0.7, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    <link id="u-page-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i">
    <%response.setIntHeader("Refresh",1); %>
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "parking management system",
		"logo": "/images/Logo.png"
}</script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Parking Availability">
    <meta property="og:type" content="website">
  </head>
  <body class="u-body u-xl-mode" data-lang="en"><header class="u-clearfix u-header u-header" id="sec-80e9"><div class="u-clearfix u-sheet u-sheet-1">
        <a href="Home.html" class="u-image u-logo u-image-1" data-image-width="458" data-image-height="105" title="Home">
          <img src="/images/Logo.png" class="u-logo-image u-logo-image-1">
        </a>
        <nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1">
          <div class="menu-collapse" style="font-size: 1rem; letter-spacing: 0px;">
            <a class="u-button-style u-custom-left-right-menu-spacing u-custom-padding-bottom u-custom-top-bottom-menu-spacing u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="#">
              <svg class="u-svg-link" viewBox="0 0 24 24"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
              <svg class="u-svg-content" version="1.1" id="menu-hamburger" viewBox="0 0 16 16" x="0px" y="0px" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns="http://www.w3.org/2000/svg"><g><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
</g></svg>
            </a>
          </div>
          <div class="u-custom-menu u-nav-container">
            <ul class="u-nav u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="Home.html" style="padding: 10px 20px;">Home</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="About.html" style="padding: 10px 20px;">About</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" href="Parking-Availability.html" style="padding: 10px 20px;">Parking-Availability</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-hover-palette-2-base" style="padding: 10px 20px;">Login</a><div class="u-nav-popup"><ul class="u-h-spacing-20 u-nav u-unstyled u-v-spacing-10 u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link u-white" href="a_login.html">Admin Login</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link u-white" href="u_login.html">User Login</a>
</li></ul>
</div>
</li></ul>
          </div>
          <div class="u-custom-menu u-nav-container-collapse">
            <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
              <div class="u-inner-container-layout u-sidenav-overflow">
                <div class="u-menu-close"></div>
                <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-3"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="/Home.html">Home</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="About.html">About</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Parking-Availability.html">Parking-Availability</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link">Login</a><div class="u-nav-popup"><ul class="u-h-spacing-20 u-nav u-unstyled u-v-spacing-10 u-nav-4"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="a_login.html">Admin Login</a>
</li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="u_login.html">User Login</a>
</li></ul>
</div>
</li></ul>
              </div>
            </div>
            <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
          </div>
        </nav>
      </div></header>
    <section class="u-align-center u-clearfix u-image u-shading u-section-1" id="carousel_5586" data-image-width="2501" data-image-height="1677">
      <div class="u-clearfix u-sheet u-sheet-1">
        <h2 class="u-custom-font u-font-source-sans-pro u-text u-text-1">Parking Spots Availability</h2>
        <div class="u-expanded-width u-table u-table-responsive u-table-1">
        <%!
        Connection conn = null;
        %>
        <table class="u-table-entity">
            <colgroup>
              <col width="20%">
              <col width="20%">
              <col width="20%">
              <col width="20%">
              <col width="20%">
            </colgroup>
            <tbody class="u-table-body">
              <tr style="height: 46px;">
                <td class="u-border-1 u-border-grey-dark-1 u-table-cell">Parking ID</td>
                <td class="u-border-1 u-border-grey-dark-1 u-table-cell">Parking Name</td>
                <td class="u-border-1 u-border-grey-dark-1 u-table-cell">Parking Location</td>
                <td class="u-border-1 u-border-grey-dark-1 u-table-cell">Parking Capacity</td>
                <td class="u-border-1 u-border-grey-dark-1 u-table-cell">Parking Used</td>
              </tr>
          <%
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	String url="jdbc:mysql://upszsyyyksaxwnso:zvT431LkkJUz3qEf452q@bhhdo6ctnwedt2vk8miw-mysql.services.clever-cloud.com:3306/bhhdo6ctnwedt2vk8miw";
        	String user = "upszsyyyksaxwnso";
        	String pass = "zvT431LkkJUz3qEf452q";
        	conn = DriverManager.getConnection(url,user,pass);
        	System.out.println("Connection Success.");
        	String query = "SELECT * FROM parkingspots;";
        	Statement stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(query);
        	while(rs.next()){
        %>
              <tr style="height: 46px;">
                <td class="u-border-1 u-border-grey-dark-1 u-table-cell"><% out.println(rs.getInt(1)); %></td>
                <td class="u-border-1 u-border-grey-dark-1 u-table-cell"><% out.println(rs.getInt(2)); %></td>
                <td class="u-border-1 u-border-grey-dark-1 u-table-cell"><% out.println(rs.getInt(3)); %></td>
                <td class="u-border-1 u-border-grey-dark-1 u-table-cell"><% out.println(rs.getInt(4)); %></td>
                <td class="u-border-1 u-border-grey-dark-1 u-table-cell"><% out.println(rs.getInt(5)); %></td>
              </tr>
              <%
        			}
        	    		}catch(Exception e){
        			System.out.println("Connection Failed due to following error: ");
        			e.printStackTrace();
        		}finally{
        			conn.close();
        		}
              %>
            </tbody>
          </table>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-220b"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">Sample text. Click to select the Text Element.</p>
      </div></footer>
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/website-templates" target="_blank">
        <span>Website Templates</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="" target="_blank">
        <span>Website Builder Software</span>
      </a>. 
    </section>
  
</body></html>