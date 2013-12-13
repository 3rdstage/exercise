<?xml version="1.0" encoding="utf-8"?>
<schema xmlns="http://purl.oclc.org/dsdl/schematron">
<title>Schematron for Service Meta</title>
<ns prefix="items" uri="http://www.thirdstage.org/example/ns/sales-items"/>
<ns prefix="xs" uri="http://www.w3.org/2001/XMLSchema"/>
<pattern>
	<rule context="/items:sales-items/items:sales-item[data(items:measurable) eq 'false']">
		<assert test="empty(items:dimensions)" id='non-measurable-item-has-no-dimensions'>
		Not measurable item should not have dimensions
		</assert>
	</rule>
	<rule context="/items:sales-items/items:sales-item[items:max-price]">
		<assert test="items:max-price/number() ge items:price/number()">
		The price should be less than or equal to max-price.
		</assert>
	</rule>
	<rule context="/items:sales-items/items:sales-item[items:min-price]">
		<assert test="items:price/number() ge items:min-price/number()">
		The price should be greater than or equal to min-price.
		</assert>
	</rule>	
	<rule context="/items:sales-items/items:sales-item[items:max-price][items:min-price]">
		<assert test="items:max-price/number() ge items:min-price/number()">
		The max-price should be greater than or equal to min-price.
		</assert>
	</rule>
	<rule context="/items:sales-items/items:sales-item[items:valid-from][items:valid-through]">
		<assert test="data(items:valid-through) ge data(items:valid-from)">
		The valid-through should be greater than or equal to valid-from.
		</assert>
	</rule>
	<rule context="/items:sales-items/items:sales-item[items:valid-from]">
		<assert test="if(data(items:is-valid) eq 'true') then (current-date() ge xs:date(items:valid-from)) else 'true'">
		The item is specified to be valid, although current date is before valid-from.
		That means is-valid and valid-from is incompatible.
		</assert>
	</rule>
	<rule context="/items:sales-items/items:sales-item[items:valid-through]">
		<assert test="if(data(items:is-valid) eq 'true') then (xs:date(items:valid-through) ge current-date()) else 'true'"
			id="items-after-valid-through-can-not-be-valid">
		The item is specified to be valid, although the current date is after valid-through.
		That means is-valid and valid-through is incompatible.
		</assert>
	</rule>			
</pattern>
</schema>