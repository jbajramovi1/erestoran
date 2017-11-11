import Ember from 'ember';

export default Ember.Component.extend({
  adminpanel:Ember.inject.controller(),
  actions:{
    openAddUser:function(){
        this.get('adminpanel').send('openAddUser');
    }
  }
});
