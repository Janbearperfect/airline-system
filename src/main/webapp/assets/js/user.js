
	function updateUser(id){
		var flag=confirm("你确定更改吗")
		if(flag){
			location.href='updateUser/'+id;
		}
	}
