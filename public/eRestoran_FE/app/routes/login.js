import Ember from 'ember';

export default Ember.Route.extend({
    account: Ember.inject.service('account-service'),
    session: Ember.inject.service('session-service'),
    actions:{
        authenticate(){
          this.controllerFor('login').send('login',this.controller.get("username"),this.controller.get("password"));
          

        }
    }
});
