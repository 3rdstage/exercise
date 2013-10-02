
<#function square num>
	<#return (num*num)>
</#function>

<table border='1' cellspacing='1' cellpadding='1'>
<tr>
	<th>Number</th>
	<th>Square</th>
</tr>
<#list nums as num>
	<tr>
		<td>${num}</td>
		<td>${square(num)}</td>
	</tr>
</#list>
</table>
	

	