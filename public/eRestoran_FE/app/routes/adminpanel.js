import Ember from 'ember';

export default Ember.Route.extend({
  sessionService:Ember.inject.service('session-service'),
  notifications: Ember.inject.service('notification-messages'),
  setupController: function(controller, model) {
    this._super(controller, model);
  },
  beforeModel(transition) {
    if (!this.get('sessionService').isAdmin()) {
      this.get('notifications').error("You can't access admin panel without permissions!", {
       autoClear: true,
       clearDuration: 1500
        });
      this.transitionTo('home');
    }
  }
});
