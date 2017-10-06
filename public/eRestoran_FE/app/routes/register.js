import Ember from 'ember';

export default Ember.Route.extend({
    account: Ember.inject.service('account-service'),
    actions:{
    register(){           
            this.get('account').
            userRegister(this.controller.get("firstName"),
                        this.controller.get("lastName"),
                        this.controller.get("email"),
                        this.controller.get("phone"),
                        this.controller.get("country"),
                        this.controller.get("city"),
                        this.controller.get("password"));
            
        }
}})

