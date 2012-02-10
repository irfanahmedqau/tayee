
<div class="">

	<h2>change password</h2>

</div>

<div class="mc">

	<div class="form">

		<div class="item fore">
			<span class="label"><em>*</em>old password</span>
			<div class="fl">
				<input type="password" ID="txtOldPwd" onblur=""
					class="text" MaxLength="16" name="txtOldPwd" />
			</div>
		</div>

		<div class="item">

			<span class="label"><em>*</em>new password</span>
			<div class="fl">
				<input type="password" ID="txtNewPwd"
					onblur="" class="text" MaxLength="16" name="txtNewPwd" />
			</div>

			<div class="clr"></div>

		</div>

		<div class="item">

			<span class="label"><em>*</em>repeat the new password</span>
			<div class="fl">
				<input type="password" ID="txtConfimPwd"
					onblur="" class="text" MaxLength="16" name="txtConfimPwd" />
			</div>
		</div>

		<div class="item">
			<span class="label">&nbsp;</span>
			<div class="fl">
				<input type="submit" name="btnSubmit" value="change password"
					onclick="return validate.AllValidate();" id="btnSubmit"
					class="btn-pass" />
			</div>
		</div>
		
	</div>
</div>