import Ember from 'ember';

export default Ember.Route.extend({
    account: Ember.inject.service('account-service'),
    actions:{
        authenticate(){
            this.get('account').userLogin(this.controller.get("username"),this.controller.get("password"));

        }

    }
});
