<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />

  <!-- Favicon -->
  <link rel="icon" type="image/png" sizes="48x48" href="${pageContext.request.contextPath}/assets/images/favicon.png">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Great+Vibes&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,400i,500,500i,600&display=swap" rel="stylesheet">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />

  <!-- Fontawesome CSS-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/all.css" />

  <!-- slick css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/slick.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/slick-theme.css">

  <!-- Custom CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/preloader.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/responsive.css" />

  <title>Kavya - Minimal Blog Template</title>

  <title>Kavya</title>
</head>

<body>
  <main class="kavya-single">
    <!-- single layout blog content -->
    <section class="single-layout">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-10 offset-md-1 col-lg-8 offset-lg-2">
            <div class="blog-content-wrap">
              
            
              <div class="blog-author-info">
                <div class="author-img">
                  <img src="${pageContext.request.contextPath}/assets/images/writer.jpg" alt="">
                </div>
                <div class="author-desc">
                  <small>written by</small>
                  <h5>Julie Perry</h5>
                  <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Laborum magni ipsa
                    fugiat pariatur! </p>
                </div>
              </div>
              <div class="comment-section">
                <div class="all-response">
                  <a class="btn view-all-btn" data-toggle="collapse" href="#collapseExample" role="button"
                    aria-expanded="false" aria-controls="collapseExample">
                    View all comments ( 3 )
                  </a>
                </div>
                <div class="collapse" id="collapseExample">
                  <div class="card comment-card">
                    <div class="card-body">
                      <div class="author-date">
                        <div class="author">
                          <img src="${pageContext.request.contextPath}/assets/images/person1.jpg" alt="" class="rounded-circle" />
                        </div>
                        <div class="inner-author-date">
                          <div class="author">
                            <span class="">Ana Grainger</span>
                          </div>
                          <div class="date"><span>1 Feb, 2019</span></div>
                        </div>
                      </div>
                      <div class="comment-text mt-2">
                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Eos quos optio
                          ab numquam excepturi commodi nam omnis eaque, culpa earum!</p>
                      </div>
                    </div>

                    <div class="card comment-card">
                      <div class="card-body">
                        <div class="author-date">
                          <div class="author">
                            <img src="${pageContext.request.contextPath}/assets/images/writer.jpg" alt="" class="rounded-circle" />
                          </div>
                          <div class="inner-author-date">
                            <div class="author">
                              <span>Julie Perry</span>
                            </div>
                            <div class="date"><span>1 Feb, 2019</span></div>
                          </div>
                        </div>
                        <div class="comment-text mt-2">
                          <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Eos quos optio
                            ab numquam excepturi commodi nam omnis eaque, culpa earum!</p>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card comment-card">
                    <div class="card-body">
                      <div class="author-date">
                        <div class="author">
                          <img src="${pageContext.request.contextPath}/assets/images/person2.jpg" alt="" class="rounded-circle" />
                        </div>
                        <div class="inner-author-date">
                          <div class="author">
                            <span class="">Iman Lindsay</span>
                          </div>
                          <div class="date"><span>1 Feb, 2019</span></div>
                        </div>
                      </div>
                      <div class="comment-text mt-2">
                        <div>Lorem ipsum dolor sit amet consectetur adipisicing elit. Quidem ipsum voluptatum suscipit
                          ipsam, dolorem quas animi magnam repellendus. Quidem unde maxime fugit, cupiditate veritatis
                          maiores dolor corporis consequuntur pariatur quo culpa ipsum! Eos aliquid deserunt incidunt
                          ratione ullam eaque. Ducimus?</div>
                      </div>
                    </div>
                  </div>
                  <div class="card comment-card">
                    <div class="card-body">
                      <div class="author-date">
                        <div class="author">
                          <img src="${pageContext.request.contextPath}/assets/images/person3.jpg" alt="" class="rounded-circle" />
                        </div>
                        <div class="inner-author-date">
                          <div class="author">
                            <span class="">Simone Bob</span>
                          </div>
                          <div class="date"><span>1 Feb, 2019</span></div>
                        </div>
                      </div>
                      <div class="comment-text mt-2">
                        <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Eos quos optio
                          ab numquam excepturi commodi nam omnis eaque, culpa earum!</p>
                      </div>
                    </div>
                  </div>
                </div>
                <form class="comment-form">
                  <h5>Leave a comment</h5>
                  <div class="row">
                    <div class="col-12 col-md-6 mb-4">
                      <input type="text" class="form-control" placeholder="Full Name">
                    </div>
                    <div class="col-12 col-md-6 mb-4">
                      <input type="email" class="form-control" placeholder="Email">
                    </div>
                    <div class="col-12 mb-4">
                      <textarea rows="7" class="form-control" placeholder="Comment"></textarea>
                    </div>
                  </div>
                  <button class="btn btn-solid">Submit</button>
                </form>
              </div>

            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Single Layout Blog content end -->

    

    
  </main>

  <!-- Javascript -->
  <script src="${pageContext.request.contextPath}/assets/js/jquery-3.4.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/slick.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/jquery.sticky.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/ResizeSensor.min.js"></script>
  <script src="${pageContext.request.contextPath}/assets/js/theia-sticky-sidebar.min.js"></script>
  <script
    src="https://platform-api.sharethis.com/js/sharethis.js#property=5e14739168a9ad001281e73c&product=inline-share-buttons"
    async="async"></script>
  <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>


</body>

</html>