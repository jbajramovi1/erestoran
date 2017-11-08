import Ember from 'ember';

export default Ember.Controller.extend({
  enableDashboard:true,
  enabelRestaurants:false,
  actions: {
        openDashboard: function() {
            this.set('enableDashboard',true);
            this.set('enableRestaurants',false);
         },
         openRestaurants: function() {
           this.set('enableDashboard',false);
             this.set('enableRestaurants',true);
          }
}
});
