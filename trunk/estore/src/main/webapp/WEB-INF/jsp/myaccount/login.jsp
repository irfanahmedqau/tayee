<form>
<h2>Customer Login</h2>
<div class="item">
	<span class="label">LoginName</span>
	<div class="fl">
		<input type="text" id="loginname" name="loginname" class="text"
			tabindex="1" value="canton_research" />
	</div>
</div>
<div class="item">
	<span class="label">Password</span>
	<div class="fl">
		<input type="password" id="loginpwd" name="loginpwd" class="text"
			tabindex="2" /> <label><a href="aa" class="">forgot password?</a></label>
	</div>
</div>

<div class="item  hide " id="o-authcode">

	<span class="label">Auth Code</span>

	<div class="fl">
		<input type="text" id="authcode" style="ime-mode: disabled"
			name="authcode" class="text text-1" tabindex="6" /> <img
			style="cursor: pointer;" alt="" src="aa" onclick=""> 
			<label>&nbsp;cannot see clearly?
			<a href="javascript:void(0)" onclick="">change another one</a></label>
	</div>
</div>
<div class="item" id="autoentry">
	<span class="label">&nbsp;</span>
	<div class="fl">
		<label>
			<input type="checkbox" class="checkbox"
			checked="checked" id="" name="" />
			remember me.
		</label>
		<label>
			<input type="checkbox" class="checkbox" id="" name="" /> login automatically
		</label>
	</div>
</div>
<div class="item">
	<input type="button" id="loginsubmit" value="Login"/>
</div>
</form>