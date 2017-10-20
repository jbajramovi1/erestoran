import Ember from 'ember';

export default Ember.Controller.extend({
  accountService: Ember.inject.service('account-service'),
  sessionService:Ember.inject.service('session-service'),
  notifications: Ember.inject.service('notification-messages'),
  applicationController: Ember.inject.controller('application'),
  actions:{
    login(username,password){
      this.get('accountService').userLogin(username,password)
      .done(response => {
           this.get('notifications').success('Login successful!', {
            autoClear: true,
            clearDuration: 1500
          });
           this.get('sessionService').authenticate(username,password);
           this.get('applicationController').send('authenticate');
           this.transitionToRoute('home');
     })
     .fail(response => {
          this.get('notifications').error('Authentication error occured', {
           autoClear: true,
           clearDuration: 1500
         });
     });
    }
  }
});
