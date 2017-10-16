import Ember from 'ember';
import Restaurant from '../models/restaurant';

export default Ember.Route.extend({
  service: Ember.inject.service('restaurant-service'),

/*  setupController: function(controller) {
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
    ]),
    });
  },*/

  model(params){
    return Restaurant.create(this.get('service').getById(params.id));
  }

});
