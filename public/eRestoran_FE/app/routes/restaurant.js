import Ember from 'ember';

export default Ember.Route.extend({

  setupController: function(controller) {
    controller.setProperties({
      lat: 34.751603,
      lng: -82.0463009,
      zoom: 14,
      markers: Ember.A([
      {
        id: 'McDonalds',
        lat: 34.751603,
        lng: -82.0463009,
        animation: google.maps.Animation.DROP,
        visible: true,
      }
        ])
    });
  }


});
