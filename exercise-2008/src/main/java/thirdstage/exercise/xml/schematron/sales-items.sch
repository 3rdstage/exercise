<?xml version="1.0" encoding="utf-8"?>
<schema xmlns="http://purl.oclc.org/dsdl/schematron">
<title>Schematron for sales item catalogue</title>
<ns prefix="m" uri="http://www.thirdstage.org/example/ns/sales-items"/>
<ns prefix="xs" uri="http://www.w3.org/2001/XMLSchema"/>
<pattern>
	<rule context="/m:sales-items/m:sales-item[data(m:measurable) eq 'false']">
		<assert test="empty(m:dimensions)" id='non-measurable-item-has-no-dimensions'>
		Not measurable item should not have dimensions
		</assert>
	</rule>
	<rule context="/m:sales-items/m:sales-item[m:max-price]">
		<assert test="m:max-price/number() ge m:price/number()">
		The price should be less than or equal to max-price.
		</assert>
	</rule>
	<rule context="/m:sales-items/m:sales-item[m:min-price]">
		<assert test="m:price/number() ge m:min-price/number()">
		The price should be greater than or equal to min-price.
		</assert>
	</rule>	
	<rule context="/m:sales-items/m:sales-item[m:max-price][m:min-price]">
		<assert test="m:max-price/number() ge m:min-price/number()">
		The max-price should be greater than or equal to min-price.
		</assert>
	</rule>
	<rule context="/m:sales-items/m:sales-item[m:valid-from][m:valid-through]">
		<assert test="data(m:valid-through) ge data(m:valid-from)">
		The valid-through should be greater than or equal to valid-from.
		</assert>
	</rule>
	<rule context="/m:sales-items/m:sales-item[m:valid-from]">
		<assert test="if(data(m:is-valid) eq 'true') then (current-date() ge xs:date(m:valid-from)) else 'true'">
		The item is specified to be valid, although current date is 
		before valid-from which means is-valid and valid-from are incompatible.
		</assert>
	</rule>
	<rule context="/m:sales-items/m:sales-item[m:valid-through]">
		<assert test="if(data(m:is-valid) eq 'true') then (xs:date(m:valid-through) ge current-date()) else 'true'"
			id="items-after-valid-through-can-not-be-valid">
		The item is specified to be valid, although the current date is 
		after valid-through which means is-valid and valid-through are incompatible.
		</assert>
	</rule>			
</pattern>
</schema>