$(function(){
	
	//Model class
	var Service = Backbone.Model.extend({
		
		defaults : {
			title : 'My Service',
			price : 100,
			checked : false
		},
		
		toggle : function(){
			this.set('checked', !this.get('checked'));
		}
	});
	
	//Collection class
	var ServiceList = Backbone.Collection.extend({
		model : Service,
		
		getChecked : function(){
			return this.where({checked:true});
		}
	});
	
	//Collection object
	var services = new ServiceList([
	   new Service({title : 'Web Dvelopment', price :200}),
	   new Service({title : 'Web Design', price :250}),
	   new Service({title : 'Photography', price :100}),
	   new Service({title : 'Coffee Drinking', price :10})
	]);
	
	
	//View class
	var ServiceView = Backbone.View.extend({
		tagName : 'li',
		
		events : {
			'click': 'toggleService'
		},
		
		initialize: function(){
			this.listenTo(this.model, 'change', this.render);
		}, 
		
		render: function(){
			this.$el.html('<input type="checkbox" value="1" name="' 
				+ this.model.get('title') + '" /> ' 
				+ this.model.get('title') 
				+ '<span>$' + this.model.get('price') + '</span>');
	
			this.$('input').prop('checked', this.model.get('checked'));
			
			return this;
		},
		
		toggleService: function(){
			this.model.toggle();
		}
	});
	
	var App = Backbone.View.extend({
		el: $('#main'),
		
		initialize : function(){
			this.total = $('#total span');
			this.list = $('#services');
			
			this.listenTo(services, 'change', this.render);
			
			services.each(function(service){
				var view = new ServiceView({model: service});
				this.list.append(view.render().el);
				
				
			}, this);
		},
		
		render: function(){
			var total = 0;
			_.each(services.getChecked(), function(elem){
				total += elem.get('price');
			});
			
			this.total.text('$' + total);
	
			return this;
		}
		
	});

	new App();
})