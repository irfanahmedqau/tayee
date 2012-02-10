<h1>Register New Customer</h1>
<div id="content">
	<div class="regBox" id="innerContent">
		<div class="tBox">
			<p class="regTitle">
				<strong>Customer Information</strong>
			</p>
			<p>
				<label><em>*</em>Email</label> <input id="email" name="email"
					autocomplete="off" type="text" value="" class="fl" /> <span
					id="email_desc" class="">please fill in valid email address, you can get back the password by this.</span>
			</p>
			<p>
				<label><em>*</em>Login Name</label> <input id="name"
					name="name" type="text" value=""/> <span id="" class=""></span>
			</p>
			<p>
				<label><em>*</em>Password</label> <input id="password"
					name="password" type="password"/><span
					id="passwordDesc"></span> <span id="password_desc" class="extra">please
					set the password longer than 8 characters.</span>
			</p>
			<p>
				<label><em>*</em>Password Confirm</label> <input id="password2"
					name="password2" type="password" onblur="checkPassword2OnBlur();"
					class="fl" /> <span id="password2_desc" class="extra">retype your password</span>
			</p>
			<p class="verCode">
				<label><em>*</em>Auth Code</label> 
				<input name="validCode"
					id="validCode" type="text" class="w50 fl" /> <img
					id="valid_code_pic" alt="" src="" />
					<a href="aa">click to get a new auth code.</a>
					<span id="validCode_desc" class="extra"></span>
			</p>

		</div>
		<div class="warn agreeBox">
			<p>
				<input id="contract" name="contract" type="checkbox" class="iRadio"
					value="contract" checked="checked" /> <a href="#" onClick="">agree with ...</a>
			</p>
			<div class="btnBox">
				<button class="btn" type="button"
					onclick="javascript:mySubmit();return false;">register</button>
			</div>
		</div>
	</div>
</div>

