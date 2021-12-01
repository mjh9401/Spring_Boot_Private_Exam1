function checkIdDup(el){
	const form = $(el).closest('form').get(0);
		
	$.get('../member/getLoginIdDup',{
		isAjax : 'Y',
		loginId : form.loginId.value
	}, function(data){
		//$('.loginId-message').empty().html(data);
		$('.loginId-message').html('<div class="mt-2 text-red-600">' + data + '</div>');
	},'text')
}