import Ember from 'ember';
import Account from '../models/account';
import Comment from '../models/comment';
import Restaurant from '../models/restaurant';
export default Ember.Component.extend({
  commentService: Ember.inject.service('comment-service'),
  sessionService: Ember.inject.service('session-service'),
  notifications: Ember.inject.service('notification-messages'),
  stars:5,
  actions: {
        toggleModal: function() {
          //if (this.get('sessionService').getCurrentUser()!=null) {
            this.toggleProperty('enabled');
        /*  }
          else {
          this.get('notifications').error('Please login to continue', {
           autoClear: true,
           clearDuration: 1500
         });
       }*/
        },
        saveRating:function(){
          var account=Account.create({});
          var comment=Comment.create({});
          var restaurant=Restaurant.create({});
          account.set('id',75);
          comment.setProperties({'content':this.get('review'),'mark':this.get('stars'),'account':account});
          restaurant.set('id',this.get('model.id'))
          this.get('commentService').leaveComment(this.get('review'),this.get('stars'),new Date(),account,restaurant)
          .done(response => {
               this.get('notifications').success('Your rating is saved!', {
                autoClear: true,
                clearDuration: 1500
              });
               this.transitionTo('home');
         })
           .fail(response => {
              this.get('notifications').error('Rating error', {
               autoClear: true,
               clearDuration: 1500
             });
           });
          this.toggleProperty('enabled');

        },
        rate:function(params){
          this.set('stars',params);
        }
    }

});
