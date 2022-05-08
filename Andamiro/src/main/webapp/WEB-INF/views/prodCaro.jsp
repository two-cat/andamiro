<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

				<!-- 캐로셀 시작 ---------------------------- -->
				<div id="fullcarousel-example" data-interval="4000"
					class="carousel slide" data-ride="carousel">
					<div class="carousel-inner">
						<div class="item active">
							<img src="product_images/${item.pimage1}" style="width:100%; height:300px;">
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img src="product_images/${item.pimage2}" style="width:100%; height:300px;">
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img src="product_images/${item.pimage3}" style="width:100%; height:300px;">
							<div class="carousel-caption"></div>
						</div>

					</div>
					<a class="left carousel-control" href="#fullcarousel-example"
						data-slide="prev"><i class="icon-prev fa fa-angle-left"></i></a><a
						class="right carousel-control" href="#fullcarousel-example"
						data-slide="next"><i class="icon-next fa fa-angle-right"></i></a>
				</div>
				<!-- 캐로셀 끝------------------------------ -->
