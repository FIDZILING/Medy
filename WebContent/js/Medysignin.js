var Vue_signin = new Vue({
    el:'#signin-box-center',
    data:{
    	inputBoxNameId:'name-id',
    	inputBoxPassId:'pass-id',
        name:'用户名',
        passtype:'text',
        pass:'密码',
        check:'登  录'
    },
    methods:{
        funcUserF:function(){
        	if(this.$refs.name.value == '请输入用户名！'||this.$refs.name.value == '用户名'){
	        	this.name = '';
	        	this.inputBoxNameId = 'input-box-name-type-one';
        	}
        },
        funcUserB:function(){
        	if(this.$refs.name.value == ''){
        		this.name = '请输入用户名！';
        		this.inputBoxNameId = 'input-box-name-type-two';
        	}
        	else{
        		this.name = this.$refs.name.value;
        		this.inputBoxNameId = 'input-box-name-type-one';
			}
			if(this.$refs.name.value != '' && this.$refs.name.value != '请输入用户名！' && this.$refs.name.value != '用户名' &&
				this.$refs.pass.value != '' && this.$refs.pass.value != '请输入密码！' && this.$refs.pass.value != '密码'){
				this.$refs.btn.onclick ="";
			}
        },
        funcPassF:function(){
        	if(this.$refs.pass.value == '请输入密码！'||this.$refs.pass.value == '密码'){
	        	this.passtype = 'password';
	        	this.pass = '';
	        	this.inputBoxPassId = 'input-box-pass-type-one';
        	}
        },
        funcPassB:function(){
        	if(this.$refs.pass.value == ''){
        		this.passtype = 'text';
        		this.pass = '请输入密码！';
        		this.inputBoxPassId = 'input-box-pass-type-two';
        	}
        	else{
        		this.pass = this.$refs.pass.value;
        		this.inputBoxPassId = 'input-box-pass-type-one';
			}
			if(this.$refs.name.value != '' && this.$refs.name.value != '请输入用户名！' && this.$refs.name.value != '用户名' &&
				this.$refs.pass.value != '' && this.$refs.pass.value != '请输入密码！' && this.$refs.pass.value != '密码'){
				this.$refs.btn.onclick ="";
			}
        }
    }
});
