
<#assign n = contents?size>

<table border='1' cellspacing='0' cellpadding='1'>
	<#list contents as row>
	<tr>
		<#list row as col>
			<td>${col}</td>
		</#list>
	</tr>
	</#list>
</table>

<#assign l = line?size> 
<ol>
	<#list 1..l as i>
	<li>${line[i]}</li>
	</#list>
</ol>