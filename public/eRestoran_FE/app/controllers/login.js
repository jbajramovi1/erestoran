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
           this.get('accountService').getSession()
           .done(response => {
                  this.get('sessionService').authenticate(username,password,response.id);
                  this.get('applicationController').send('authenticate');
                  this.transitionToRoute('home');
               });

     })
     .fail(response => {
       var data = $.parseJSON(response.responseText);
        var error=null;
          if (data.email!=undefined) error=data.email;
          else if (data.password!=undefined) error=data.password;
          else error="Authentication error occured";
          this.get('notifications').error(error, {
           autoClear: true,
           clearDuration: 1500
         });

     });

    }
  }
});
