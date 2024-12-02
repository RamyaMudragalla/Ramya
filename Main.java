package multipleBrowsers;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Elements50[] applications = new Elements50[2]; // For example purposes, we'll do this for one application

		// GitHub login details and XPaths
		applications[0] = new Elements50("https://github.com/login", "mudragallaramya28@gmail.com", // Replace with your
																									// GitHub username
				"Ramya@123456789", // Replace with your GitHub password
				"//input[@id='login_field']", // XPath for username field
				"//input[@id='password']", // XPath for password field
				"//input[@name='commit']", // XPath for login button
				"//span[@class='Button-label']/child::img[@src=\"https://avatars.githubusercontent.com/u/182791502?v=4\"]", // XPath
																															// for
																													// profile
																															// button
				"//*[@id=\":r12:--label\"]", // XPath for logout button
				null);
		applications[1] = new Elements50(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0",
				"geethu13311@gmail.com", // Replace with your GitHub username
				"Geethu@13311", // Replace with your GitHub password
				"//input[@id=\"ap_email\"]", // XPath for username field
				"//*[@id=\"ap_password\"]", // XPath for password field
				"//*[@id=\"signInSubmit\"]", // XPath for login button
				"//span[@id=\"nav-link-accountList-nav-line-1\"]", // XPath for profile button
				"/html/body", // XPath for logout button
				"//input[@id=\"continue\"]" // xpath for continue button

		);
		applications[1] = new Elements50(
        		"https://www.codechef.com/login?destination=/",
        		"ramya497",
        		"Ramya@123",
        		"//*[@id=\"edit-name\"]",
        		"//*[@id=\"edit-pass\"]",
        		"//input[@id=\"edit-submit-button\"][@class=\"ccl-f-input ccl-float-right cc-login-btn\"]",
        		"//img[@src=\"https://cdn.codechef.com/sites/all/themes/abessive/images/user_default_thumb.jpg\"]",
        		"//*[@class=\"logoutButtonContainer\"]",
        		null
        		);

		// Loop through each application and perform login and logout
		for (Elements50 app : applications) {
			app.login();
			// Perform additional operations if needed
			Thread.sleep(2000);
			app.logout();
			Thread.sleep(2000);
			app.close();
		}
	}
}
