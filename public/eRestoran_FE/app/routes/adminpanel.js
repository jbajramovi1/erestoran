import Ember from 'ember';

export default Ember.Route.extend({
  sessionService:Ember.inject.service('session-service'),
  notifications: Ember.inject.service('notification-messages'),
  accountService:Ember.inject.service('account-service'),
  setupController: function(controller, model) {
    this._super(controller, model);
  },
  beforeModel(transition) {
      this.get('accountService').getSession()
      .done(response => {
             if (response.role!=="ADMIN"){
               this.get('notifications').error("You can't access admin panel without permissions!", {
                autoClear: true,
                clearDuration: 1500
                 });
               this.transitionTo('home');
           }
          });


  }
});
