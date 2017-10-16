import Ember from 'ember';

export default Ember.Controller.extend({
  session: Ember.inject.service('session-service'),
  isAuthenticated:false,
  user:null,
  actions:{
    authenticate(){
      this.set('isAuthenticated',true);
      this.set('user',this.get('session').getCurrentUser());
    },
    unauthenticate(){
      this.set('isAuthenticated',false);
      this.get('session').unauthenticate();
    }
  }
});
