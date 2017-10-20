import Ember from 'ember';
import Account from '../models/account';
import Comment from '../models/comment';
import Restaurant from '../models/restaurant';
export default Ember.Component.extend({
  comment: Ember.inject.service('comment-service'),
  stars:5,
  actions: {
        toggleModal: function() {
            this.toggleProperty('enabled');
        },
        saveRating:function(){
          var account=Account.create({});
          var comment=Comment.create({});
          var restaurant=Restaurant.create({});
          account.set('id',32);
          comment.setProperties({'content':this.get('review'),'mark':this.get('stars'),'account':account});
          restaurant.set('id',this.get('model.id'))
          this.get('comment').leaveComment(this.get('review'),this.get('stars'),account,restaurant);
          this.toggleProperty('enabled');

        },
        rate:function(params){
          this.set('stars',params);
        }
    }

});
