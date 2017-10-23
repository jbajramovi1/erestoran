import Ember from 'ember';

export default Ember.Controller.extend({
  sessionService: Ember.inject.service('session-service'),
  accountService: Ember.inject.service('account-service'),
  isAuthenticated:false,
  user:null,
  actions:{
    authenticate(){
      this.set('isAuthenticated',this.get('sessionService').isAuthenticated());
      this.set('user',this.get('sessionService').getCurrentUser());
    },
    unauthenticate(){
      this.set('isAuthenticated',false);
      this.set('user',null);
      this.get('sessionService').unauthenticate();
      this.get('accountService').logout()
      .done(response => {
           this.transitionToRoute('home');
         });
      }
    }

});
