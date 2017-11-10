import Ember from 'ember';

export default Ember.Controller.extend({
  enableDashboard:true,
  enableRestaurants:false,
  enableAddRestaurant:false,
  enableLocations:false,
  enableAddLocation:false,
  actions: {
        openDashboard: function() {
            this.set('enableDashboard',true);
            this.set('enableRestaurants',false);
            this.set('enableAddRestaurant',false);
            this.set('enableLocations',false);
            this.set('enableAddLocation',false);
         },
         openRestaurants: function() {
           this.set('enableDashboard',false);
             this.set('enableRestaurants',true);
             this.set('enableAddRestaurant',false);
             this.set('enableLocations',false);
             this.set('enableAddLocation',false);
          },
          openAddRestaurant: function() {
            this.set('enableDashboard',false);
              this.set('enableRestaurants',false);
              this.set('enableAddRestaurant',true);
              this.set('enableLocations',false);
              this.set('enableAddLocation',false);
          },
          openLocations: function() {
            this.set('enableDashboard',false);
              this.set('enableRestaurants',false);
              this.set('enableAddRestaurant',false);
              this.set('enableLocations',true);
              this.set('enableAddLocation',false);
          },
          openAddLocation: function() {
            this.set('enableDashboard',false);
              this.set('enableRestaurants',false);
              this.set('enableAddRestaurant',false);
              this.set('enableLocations',false);
              this.set('enableAddLocation',true);
          }
}
});
