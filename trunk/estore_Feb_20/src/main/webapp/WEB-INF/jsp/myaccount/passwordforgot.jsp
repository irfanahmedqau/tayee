<div id="ShowLostpass">
	<p class="back_tips">please type in your registered email address.</p>

	<form name="form1" method="post" action="" id="form1">

		<p id="input_email">
			<label>Email:</label>
			<input name="txtEmail" type="text" maxlength="40" id="txtEmail" />
		</p>

		<p id="input_vcode">
			<label>Auth Code: </label><input
				name="txtVerifyCode" type="text" maxlength="4" id="txtVerifyCode"
				class="validate" size="10" onkeydown="" />
				<span>type the content shown below</span>
		</p>

		<p class="form_validate">
			<label></label>
			<span class="login_form_validate"><a href="">
				<img src="" width="" height="" id='imgVcode' title="click to change the auth code" /></a>
			</span>
			<span
				class="login_form_hint">cannot see clearly?
				<a href="aa">change a picture</a>
			</span>
		</p>

		<input onclick="__doPostBack('btnConfirm','')" name="btnConfirm"
			type="button" id="btnConfirm" style="display: none" value="send"/>

	</form>

</div>
