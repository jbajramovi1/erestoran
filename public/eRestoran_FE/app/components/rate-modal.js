import Ember from 'ember';

export default Ember.Component.extend({
  comment: Ember.inject.service('comment-service'),
  stars:5,
  actions: {
        toggleModal: function() {
            this.toggleProperty('enabled');
        },
        saveRating:function(){
          this.get('comment').leaveComment(this.get('review'),this.get('stars'),this.get('model.id'),32);
          this.toggleProperty('enabled');

        },
        rate:function(params){
          this.set('stars',params);
        }
    }

});
