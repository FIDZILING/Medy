var Vue_signup = new Vue({
    el:'#signup-box-center',
    data:{
        inputBoxNameId:'name-id',
        inputBoxPassId:'pass-id',
        inputBoxCheckPassId:'checkpass-id',
        name:'用户名',
        pass:'密码',
        checkpass:'确认密码',
        passtype:'text',
		checkpasstype:'text',
		check:'注  册'
    },
    methods:{
        funcNameF:function(){
            if(this.$refs.refName.value == '用户名' || this.$refs.refName.value == '请输入正确的用户名！'){
            	this.name = '';
            	this.inputBoxNameId = 'input-box-name-type-one';
            }
        },
        funcNameB:function(){
        	if(this.$refs.refName.value == ''){
        		this.name = '请输入正确的用户名！';
        		this.inputBoxNameId = 'input-box-name-type-two';
        	}
        	else{
        		this.name = this.$refs.refName.value;
        		this.inputBoxNameId = 'input-box-name-type-one';
        	}
        	if(this.$refs.refName.value != '用户名' && this.$refs.refName.value != '请输入正确的用户名！' && this.$refs.refName.value != '' &&
        		this.$refs.refPass.value != '密码' && this.$refs.refPass.value != '请输入密码！' && this.$refs.refPass.value != '' &&
        		this.$refs.refCheckPass.value != '确认密码' && this.$refs.refCheckPass.value != '两次密码不一致！' && this.$refs.refCheckPass.value != '' &&
        		(this.$refs.abi.value == 'user' || this.$refs.abi.value == 'enterprise')){
        		this.$refs.btn.onclick ="";
        	}
        },
        funcPassF:function(){
        	if(this.$refs.refPass.value == '密码' || this.$refs.refPass.value == '请输入密码！'){
        		this.passtype = 'password';
        		this.pass = '';
            	this.inputBoxPassId = 'input-box-pass-type-one';
            }
        },
        funcPassB:function(){
        	if(this.$refs.refPass.value == ''){
        		this.passtype = 'text';
        		this.pass = '请输入密码！';
        		this.inputBoxPassId = 'input-box-pass-type-two';
        	}
        	else if(this.$refs.refPass.value != this.$refs.refCheckPass.value && this.$refs.refCheckPass.value != '' 
        		&& this.$refs.refCheckPass.value != '确认密码' && this.$refs.refCheckPass.value != '两次密码不一致！'){
        		this.checkpasstype = 'text';
        		this.$refs.refCheckPass.value = '';
        		this.pass = this.$refs.refPass.value;
        		this.checkpass = '两次密码不一致！';
        		this.inputBoxCheckPassId = 'input-box-checkpass-type-two';
        	}
        	else{
        		this.pass = this.$refs.refPass.value;
        		this.inputBoxPassId = 'input-box-pass-type-one';
        	}
        	if(this.$refs.refName.value != '用户名' && this.$refs.refName.value != '请输入正确的用户名！' && this.$refs.refName.value != '' &&
            		this.$refs.refPass.value != '密码' && this.$refs.refPass.value != '请输入密码！' && this.$refs.refPass.value != '' &&
            		this.$refs.refCheckPass.value != '确认密码' && this.$refs.refCheckPass.value != '两次密码不一致！' && this.$refs.refCheckPass.value != '' &&
            		(this.$refs.abi.value == 'user' || this.$refs.abi.value == 'enterprise')){
            		this.$refs.btn.onclick ="";
            }
        },
        funcCheckPassF:function(){
        	if(this.$refs.refCheckPass.value == '确认密码' || this.$refs.refCheckPass.value == '两次密码不一致！'){
        		this.checkpasstype = 'password';
        		this.checkpass = '';
            	this.inputBoxCheckPassId = 'input-box-checkpass-type-one';
            }
        },
        funcCheckPassB:function(){
        	if(this.$refs.refCheckPass.value != this.$refs.refPass.value){
        		this.checkpasstype = 'text';
        		this.checkpass = '两次密码不一致！';
        		this.inputBoxCheckPassId = 'input-box-checkpass-type-two';
        	}
        	else{
        		this.checkpass = this.$refs.refCheckPass.value;
        		this.inputBoxCheckPassId = 'input-box-checkpass-type-one';
        	}
        	if(this.$refs.refName.value != '用户名' && this.$refs.refName.value != '请输入正确的用户名！' && this.$refs.refName.value != '' &&
            		this.$refs.refPass.value != '密码' && this.$refs.refPass.value != '请输入密码！' && this.$refs.refPass.value != '' &&
            		this.$refs.refCheckPass.value != '确认密码' && this.$refs.refCheckPass.value != '两次密码不一致！' && this.$refs.refCheckPass.value != '' &&
            		(this.$refs.abi.value == 'user' || this.$refs.abi.value == 'enterprise')){
            		this.$refs.btn.onclick ="";
            }
        },
        funcAbi:function(){
        	if(this.$refs.refName.value != '用户名' && this.$refs.refName.value != '请输入正确的用户名！' && this.$refs.refName.value != '' &&
            		this.$refs.refPass.value != '密码' && this.$refs.refPass.value != '请输入密码！' && this.$refs.refPass.value != '' &&
            		this.$refs.refCheckPass.value != '确认密码' && this.$refs.refCheckPass.value != '两次密码不一致！' && this.$refs.refCheckPass.value != '' &&
            		(this.$refs.abi.value == 'user' || this.$refs.abi.value == 'enterprise')){
            		this.$refs.btn.onclick ="";
            }
        },
    }
});


