import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../user';
import { AppService } from '../../app.service';
import { CustomerService } from '../../customer.service';
import { Router } from '@angular/router';
import { UserService } from '../../shared_service/user.service';
import { ReviewService } from '../../shared_service/review.service';
import { FavouriteService } from '../../shared_service/favourite.service';
import { Favourite } from '../../favourite';
import { Query } from '../../query';
import { QueryService } from '../../shared_service/query.service';
import { Review } from 'src/app/review';
import { SmsMessageService } from '../../shared_service/sms-message.service';
import { SmsMessage } from '../../sms-message';
import { SearchHistory } from '../../search-history';
import { SearchHistoryService } from '../../shared_service/search-history.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css', '../../../../node_modules/bootstrap/dist/css/bootstrap.min.css']
})
export class HomeComponent {

  public users:User[];
  public reviews:Review[];
  public reviewsByMovieID:Review[];
  public favourites:Favourite[];
  public favouritesByUsername:Favourite[];
  public queries:Query[];
  public addressedQueries:Query[];
  public smsMessages:SmsMessage[];
  public allSearches:SearchHistory[];
  public recommendedForYouGenres:Number[];

  reviewsTableVisible = false;
  genresTableVisible = false;
  actorsTableVisible = false;
  favouritesTableVisible = false;
  addressedQueriesVisible = false;
  recommendedTableVisible = false;
  exit = false;

  id: string = "";
  keyword: string = "";
  response: any;
  require: any;
  data: any;
  leo: any;
  fullname: any;
  fname: any;
  lname: any;
  recommended: any;

  genre: any;
  genres: any;
  username:String = '';
  password:String = '';
  isValid:boolean;
  accountExists:boolean;
  user:User;
  accountValid:boolean;
  lengthValid:boolean;
  review:Review = new Review();
  reviewText:String = '';
  reviewDate:String;
  hasProfanity:String = '';
  movie_id:Number = 0;
  favourite:Favourite = new Favourite();
  isAdmin:boolean;
  isFavourite:boolean;

  query1:Query = new Query();
  queryTitle:String = '';
  query:String = '';
  queryIsSaved:boolean;
  phoneNumber:Number = 0;
  phoneNumberIsAdded:boolean;
  movie_title:String = '';
  movie_release_date:String = '';
  movie_overview:String = '';
  smsMessage:String = '';
  searchHist:SearchHistory = new SearchHistory();
  creditCardIsAdded:boolean;
  cardNum:String = '';
  isNum:boolean = false;
  isPremium:boolean = false;
  trailerLink: any;

  constructor(private http: HttpClient, private _reviewService:ReviewService, private _userService:UserService, private app: AppService, private customer: CustomerService, 
    private _favouriteService: FavouriteService, private _queryService: QueryService, private _smsService: SmsMessageService, private _searchHistoryService: SearchHistoryService, 
    private router: Router){

  }

  ngOnInit() {
    this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data);
    })

    this._userService.getUsers().subscribe((users) => {
      console.log(users);
      this.users=users;
  }, (error) => {
    console.log(error);
  })

  this.user=this._userService.getter();

  this._reviewService.getReviews().subscribe((reviews) => {
    console.log(reviews);
    this.reviews=reviews;
  }, (error) => {
    console.log(error);
  })

  this._favouriteService.getFavourites().subscribe((favourites) => {
    console.log(favourites);
    this.favourites=favourites;
  }, (error) => {
    console.log(error);
  })

  this._queryService.getQueries().subscribe((queries) => {
    console.log(queries);
    this.queries=queries;
  }, (error) => {
    console.log(error);
  })

  this._smsService.getMessages().subscribe((messages) => {
    console.log(messages);
    this.smsMessages=messages;
  }, (error) => {
    console.log(error);
  })

  this._searchHistoryService.getAllSearchHistory().subscribe((searches) => {
    console.log(searches);
    this.allSearches=searches;
  }, (error) => {
    console.log(error);
  })
  }

  tryLogin(username, password) {
    this._userService.getUsers().subscribe((users) => {
      console.log(users);
      this.users=users;
  }, (error) => {
    console.log(error);
  })

    for (var i = 0; i < this.users.length; i++){
      this.isAdmin = false;
      this.isValid = false;
      this.accountExists = false;
      if (username == "admin" && password == "admin"){
        this.isAdmin = true;
        this.isValid = true;
        this.accountExists = true;
        this.exit = true;
        if (this.exit == true){
          i = this.users.length;
        }
        this.router.navigateByUrl('/admin');
      }
      else if (this.username == this.users[i].username && this.password != this.users[i].password){
        this.accountExists = true;
        this.isAdmin = true;
        this.isValid = false;
        this.exit = true;
        if (this.exit == true){
          i = this.users.length;
        }
        this.router.navigateByUrl('/home');
      }
      else if (this.username == this.users[i].username && this.password == this.users[i].password){
          this.accountExists = true;
          this.isValid = true;
          this.isAdmin = true;
          this.exit = true;
        if (this.exit == true){
          i = this.users.length;
        }
          this.router.navigateByUrl('/home');
        }
      }
  }

  processForm(){
    if(this.user.id==undefined){
      this.accountValid = true;
        for (var i = 0; i < this.users.length; i++){
          if (this.user.username == this.users[i].username){
            this.accountValid = false;
            this.lengthValid = true;
          }
        }
        if(this.accountValid == true && this.user.username.length >= 4 && this.user.username.length <= 15){
          this._userService.createUser(this.user).subscribe((user)=>{
            console.log(user);
            this.lengthValid = true;
            this.accountValid = true;
            this._userService.getUsers().subscribe((users) => {
              console.log(users);
              this.users=users;
          }, (error) => {
            console.log(error);
          })
        
          this.user=this._userService.getter();

            this.router.navigate(['/']);
          },(error)=>{
            console.log(error);
          });
        }
        else if (this.accountValid == true && this.user.username.length < 4 || this.user.username.length > 15){
            this.lengthValid = false;
        }
      }
        else{
          this.router.navigate(['/']);
      }
  }

  checkForProfanity(movie_id, movie_name, username, reviewText){
    this.http.get('https://www.purgomalum.com/service/containsprofanity?text=' + reviewText)
    .subscribe((data) => {
      this.data = data;
      this.hasProfanity = JSON.stringify(this.data);
      if (this.hasProfanity == "true") 
      {
        console.log("Text contains profanity and has not been added to Reviews!");
      }

      if (this.hasProfanity == "false")
      {
        this.addReview(movie_id, movie_name, username, reviewText);
      }

    },(error) => {
      console.log(error);
    });
  }

  addReview(movie_id, movie_name, username, reviewText){
    var date = new Date();
    this.reviewText = reviewText;
    this.review.movie_id = movie_id;
    this.review.movie_name = movie_name;
    this.review.username = username;
    this.review.reviewText = this.reviewText;
    this.review.reviewDate = date;

    this._reviewService.createReview(this.review).subscribe((review) => {
      console.log(review);
    this._reviewService.getReviews().subscribe((reviews) => {
      console.log(reviews);
      this.reviews=reviews;
    }, (error) => {
      console.log(error);
    })
    } ,(error) => {
    console.log(error);
    });
  }

  viewReviews(movie_id){
    this._reviewService.getReviews().subscribe((reviews) => {
      console.log(reviews);
      this.reviews=reviews;
    }, (error) => {
      console.log(error);
    })

    var count = 0;

    for(var i = 0; i < this.reviews.length; i++){
      if (this.reviews[i].movie_id == movie_id){
        count++;
      }
    }

    this.reviewsByMovieID = new Array(count);
    var occupiedSpaces = 0;

    for(var i = 0; i < this.reviews.length; i++){
      if (this.reviews[i].movie_id == movie_id){
        this.reviewsByMovieID[occupiedSpaces] = this.reviews[i];
        occupiedSpaces++;
      }
    }

    this.reviewsTableVisible = true;
  }

  addToFavourites(username, movie_id, title, poster_path, release_date){
    this.isFavourite = false;
    this.favourite.username = username;
    this.favourite.movie_id = movie_id;
    this.favourite.title = title;
    this.favourite.poster_path = poster_path;
    this.favourite.release_date = release_date;

    for (var i = 0; i < this.favourites.length; i++){
      if (this.favourites[i].username == username && this.favourites[i].title == title){
        this.isFavourite = true;
      }
    }

    if (this.isFavourite == false){
      this._favouriteService.createFavourite(this.favourite).subscribe((favourite) => {
        console.log(favourite);
      this._favouriteService.getFavourites().subscribe((favourites) => {
        console.log(favourites);
        this.favourites = favourites;
      }, (error) => {
        console.log(error);
      })
    })
    }
  }

  viewFavourites(username){
    this._favouriteService.getFavourites().subscribe((favourites) => {
      console.log(favourites);
      this.favourites=favourites;
    }, (error) => {
      console.log(error);
    })

    var count = 0;

    for (var i = 0; i < this.favourites.length; i++){
      if (this.favourites[i].username == username){
        count++;
      }
    }

    this.favouritesByUsername = new Array(count);
    var occupiedSpaces = 0;

    for (var i = 0; i < this.favourites.length; i++){
      if (this.favourites[i].username == username){
        this.favouritesByUsername[occupiedSpaces] = this.favourites[i];
        occupiedSpaces++;
      }
    }

    this.favouritesTableVisible = true;
  }

  deleteFavourite(favourite){
    this._favouriteService.deleteFavourite(favourite.id).subscribe((data) => {
      this.favourites.splice(this.favourites.indexOf(favourite), 1);
    }, (error)=>{
      console.log(error);
    })
  }

  makeQuery(queryTitle, query, username){
    this.queryIsSaved = false;
    var date = new Date();
    this.query1.username = username;
    this.query1.queryTitle = queryTitle;
    this.query1.queryText = query;
    this.query1.queryDate = date;

    this._queryService.createQuery(this.query1).subscribe((data) => {
      console.log(query);
      this._queryService.getQueries().subscribe((queries) => {
        console.log(queries);
        this.queries = queries;
      }, (error) => {
        console.log(error);
      })
    })

    this.queryIsSaved = true;
  }

  getAddressedQueriesForSpecificUser(username){
    this._queryService.getQueries().subscribe((queries) => {
      console.log(queries);
      this.queries=queries;
    }, (error) => {
      console.log(error);
    })

    var count = 0;

    for(var i = 0; i < this.queries.length; i++){
      if (this.queries[i].username == username && this.queries[i].responseText != null){
        count++;
      }
    }

    this.addressedQueries = new Array(count);
    var occupiedSpaces = 0;

    for (var i = 0; i < this.queries.length; i++){
      if (this.queries[i].username == username && this.queries[i].responseText != null){
        this.addressedQueries[occupiedSpaces] = this.queries[i];
        occupiedSpaces++;
      }
    }

    console.log(this.addressedQueries);

    this.addressedQueriesVisible = true;
  }

  addPhoneNumber(username, phoneNumber){
    for(var i = 0; i < this.users.length; i++){
      if (this.users[i].username == username && phoneNumber.length == 10){
        this.phoneNumberIsAdded = true;
        this.users[i].phoneNumber = phoneNumber;
        this._userService.updateUser(this.users[i]).subscribe((users) => {
          console.log(users);
          this.users = users;
        }, (error) => {
          console.log(error);
        })

      } else if (this.users[i].username == username && phoneNumber.length != 10){
        this.phoneNumberIsAdded = false;
      }
    }
  }

  addCreditCard(username, cardNum1, cardNum2, cardNum3, cardNum4)
  {
    if (Number.isInteger(cardNum1) && Number.isInteger(cardNum2) && Number.isInteger(cardNum3) && Number.isInteger(cardNum4))
    {
      this.isNum = true;
    }
    else
    {
      this.isNum = false;
    }

    this.cardNum = cardNum1 + cardNum2 + cardNum3 + cardNum4;

    for (var i =0; i < this.users.length; i++){
      if (this.users[i].username == username && this.cardNum.length == 16){
        this.creditCardIsAdded = true;
        this.users[i].cardNum = this.cardNum.toString();
        this._userService.updateUser(this.users[i]).subscribe((users) => {
          console.log(users);
          this.users = users;
        }, (error) => {
          console.log(error);
        })
      } else if (this.users[i].username == username && this.cardNum.length != 16){
        this.creditCardIsAdded = false;
      }
    }
  }

  displayPremiumStatus(username)
  {
    for (var i =0; i < this.users.length; i++){
      if (this.users[i].username == username && this.users[i].cardNum.toString() != "0"){
        this.isPremium = true;
        }
      }
  }

  sendSmsMessage(username, movie_title, movie_release_date, movie_overview){
    for(var i = 0; i < this.users.length; i++){
      if (this.users[i].username == username && this.users[i].phoneNumber != 0){
        this.phoneNumber = this.users[i].phoneNumber;
        this.movie_title = movie_title;
        this.movie_release_date = movie_release_date;
        this.movie_overview = movie_overview;
        this.smsMessage = "\n Movie Title: " + this.movie_title + "\n Release Date: " + this.movie_release_date + "\n Overview: " + this.movie_overview;
        i = this.users.length;
        this.http.get('https://moviedb-backend.azurewebsites.net/api/messages/sendSmsMessage/' + this.phoneNumber + '/' + this.smsMessage)
        .subscribe((data) => {
          this.data = data;
        });
      }
    }
  }

  addToSearchHistory(mv_id, mv_title, genre_id, username){
    this.searchHist.movie_id = mv_id;
    this.searchHist.movie_title = mv_title;
    this.searchHist.genre_id = genre_id;
    this.searchHist.username = username;

    this._searchHistoryService.createSearchHistory(this.searchHist).subscribe((searches) => {
      console.log(searches);
      this._searchHistoryService.getAllSearchHistory().subscribe((searches) => {
        console.log(searches);
        this.allSearches = searches;
      }, (error) => {
        console.log(error);
      })
    })
  }

  getRecommededForYou(username){
    var count = 0;
    // Find how many favourites the user has.
    for (var i = 0; i < this.allSearches.length; i++){
      if (this.allSearches[i].username == username){
        count ++;
      }
    }

    // If a username match is found in the favourites list.
    if (count > 0){
      this.recommendedForYouGenres = new Array(count);
      var recommendedPosition = 0;
      // Add the genres of all of the movies in the user's favourites list.
      for (var i = 0; i < this.allSearches.length; i++){
        if (this.allSearches[i].username == username){
          this.recommendedForYouGenres[recommendedPosition] = this.allSearches[i].genre_id;
          recommendedPosition++;
        }
      }
    
      // Gather recommended films based on the genres gathered above and store in recommeneded JSON String.
      for (var i = 0; i < this.recommendedForYouGenres.length; i++){
        this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres='
        + this.recommendedForYouGenres[i] + '&page=' + i+2)
          .subscribe((data) => {
            this.recommended = data;

            JSON.stringify(this.recommended);
            console.log(this.recommended);
          });
        }

        this.recommendedTableVisible = true;
      }

      else {
        return 0;
      }
    }

  searchByKeywordInEnglish(){
    this.http.get('https://api.themoviedb.org/3/search/movie?query=' + this.keyword + '&api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data)
    });
  }

  searchByKeywordInFrench(){
    this.http.get('https://api.themoviedb.org/3/search/movie?query=' + this.keyword + '&api_key=383b0d4a4c7c80d01138a5ad8902b121&language=fr')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data)
    });
  }

  searchByKeywordInGerman(){
    this.http.get('https://api.themoviedb.org/3/search/movie?query=' + this.keyword + '&api_key=383b0d4a4c7c80d01138a5ad8902b121&language=de')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data)
    });
  }

  searchByKeywordInSpanish(){
    this.http.get('https://api.themoviedb.org/3/search/movie?query=' + this.keyword + '&api_key=383b0d4a4c7c80d01138a5ad8902b121&language=es')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data)
    });
  }

  searchByKeywordInItalian(){
    this.http.get('https://api.themoviedb.org/3/search/movie?query=' + this.keyword + '&api_key=383b0d4a4c7c80d01138a5ad8902b121&language=it')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data)
    });
  }

  mostPopularMovies(){
    this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data);
    });
  }

  mostPopularMoviesInEnglish(){
    this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data);
    });
  }

  mostPopularMoviesInFrench(){
    this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=fr&sort_by=popularity.desc&include_adult=false&include_video=false&page=1')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data);
    });
  }

  mostPopularMoviesInGerman(){
    this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=de&sort_by=popularity.desc&include_adult=false&include_video=false&page=1')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data);
    });
  }

  mostPopularMoviesInSpanish(){
    this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=es&sort_by=popularity.desc&include_adult=false&include_video=false&page=1')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data);
    });
  }

  mostPopularMoviesInItalian(){
    this.http.get('https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=it&sort_by=popularity.desc&include_adult=false&include_video=false&page=1')
    .subscribe((data) => {
      this.data = data;

      JSON.stringify(data);

      console.log(data);
    });
  }

  searchByName(){
    this.http.get('https://api.themoviedb.org/3/search/person?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&page=1&include_adult=false&search_type=ngram&query=' + this.fname + "+" + this.lname)
    .subscribe((fullname) => {
      this.actorsTableVisible = true;
      this.fullname = fullname;

      console.log(fullname);
    });
  }

  searchByGenreAction(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=28&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreAdventure(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=12&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreAnimation(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=16&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreComedy(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=35&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreCrime(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=80&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreDrama(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=18&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreFamily(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=10751&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreFantasy(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=14&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreHistory(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=36&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreMusic(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=10402&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreMystery(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=9648&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreRomance(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=10749&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreScienceFiction(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=878&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreTVMovie(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=10770&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreThriller(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=53&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreWar(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=10752&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreWestern(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=37&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  searchByGenreHorror(){
    this.http.get("https://api.themoviedb.org/3/discover/movie?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US&sort_by=popularity.desc&with_genres=27&page=1")
    .subscribe((genre) => {
      this.genresTableVisible = true;
      this.genre = genre;

      console.log(genre);
    });
  }

  getMovieTrailers(movie_id)
  {
    this.trailerLink = this.http.get("https://api.themoviedb.org/3/movie/" + movie_id + "/videos?api_key=383b0d4a4c7c80d01138a5ad8902b121&language=en-US")
    .subscribe((trailerLink) => {
      this.trailerLink = trailerLink;

      console.log(trailerLink);
    })
  }

  resetTrailerString()
  {
    this.trailerLink = null;
  }

}
