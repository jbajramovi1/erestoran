import Ember from 'ember';

export default Ember.Component.extend({
  adminpanel:Ember.inject.controller(),
  actions:{
    openAddRestaurant:function(){
        this.get('adminpanel').send('openAddRestaurant');
    }
  }
});