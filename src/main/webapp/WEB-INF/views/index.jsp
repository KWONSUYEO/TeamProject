<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/review.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/KwonValidChecker.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>

</head>
<body>
	<table class="menuTitle">
		<tr>
			<td><a href="go">HOME</a></td>
			<td><a href="info.go">회원정보</a></td>
			<td><a href="dibs.go">찜목록</a></td>
			<td><a href="review.go">방문후기</a></td>
		</tr>
	</table>

	<table class="LoginArea">
		<tr>
			<td><jsp:include page="${loginPage }" /></td>
			<td><div id="r">
					<h1>${r }</h1>
				</div></td>
			<td><div id="dr">
					<h5>${dr }</h5>
				</div></td>
		</tr>
	</table>

	<table>
		<tr>
			<td class="mainPage" align="center"><jsp:include page="${main }" />
			</td>
		</tr>
	</table>
	
	<div id="map" style="width: 1800px; height: 700px;"></div>
	<div class="map_wrap">
		<div id="map"
			style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

		<div id="menu_wrap" class="bg_white">
			<div class="option">
				<div>
					<form onsubmit="searchPlaces(); return false;">
						키워드 : <input type="text" value="맛집" id="keyword" size="15">
						<button type="submit">검색하기</button>
					</form>
				</div>
			</div>
			<hr>
			<ul id="placesList"></ul>
			<div id="pagination"></div>
		</div>
	</div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ee1a464535042fcbd8169712c5114f6d"></script>
	<script>
		var markers = [];

		var mapContainer = document.getElementById('map'), mapOption = {
			center : new kakao.maps.LatLng(37.566826, 126.9786567),
			level : 13
		};

		var map = new kakao.maps.Map(mapContainer, mapOption);

		var ps = new kakao.maps.services.Places();

		var infowindow = new kakao.maps.InfoWindow({
			zIndex : 1
		});

		searchPlaces();

		function searchPlaces() {

			var keyword = document.getElementById('keyword').value;

			if (!keyword.replace(/^\s+|\s+$/g, '')) {
				alert('키워드를 입력해주세요!');
				return false;
			}

			ps.keywordSearch(keyword, placesSearchCB);
		}

		function placesSearchCB(data, status, pagination) {
			if (status === kakao.maps.services.Status.OK) {

				displayPlaces(data);

				displayPagination(pagination);

			} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

				alert('검색 결과가 존재하지 않습니다.');
				return;

			} else if (status === kakao.maps.services.Status.ERROR) {

				alert('검색 결과 중 오류가 발생했습니다.');
				return;

			}
		}

		function displayPlaces(places) {

			var listEl = document.getElementById('placesList'), menuEl = document
					.getElementById('menu_wrap'), fragment = document
					.createDocumentFragment(), bounds = new kakao.maps.LatLngBounds(), listStr = '';

			removeAllChildNods(listEl);

			removeMarker();

			for (var i = 0; i < places.length; i++) {

				var placePosition = new kakao.maps.LatLng(places[i].y,
						places[i].x), marker = addMarker(placePosition, i), itemEl = getListItem(
						i, places[i]);

				bounds.extend(placePosition);

				(function(marker, title) {
					kakao.maps.event.addListener(marker, 'mouseover',
							function() {
								displayInfowindow(marker, title);
							});

					kakao.maps.event.addListener(marker, 'mouseout',
							function() {
								infowindow.close();
							});

					itemEl.onmouseover = function() {
						displayInfowindow(marker, title);
					};

					itemEl.onmouseout = function() {
						infowindow.close();
					};
				})(marker, places[i].place_name);

				fragment.appendChild(itemEl);
			}

			listEl.appendChild(fragment);
			menuEl.scrollTop = 0;

			map.setBounds(bounds);
		}

		function getListItem(index, places) {

			var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
					+ (index + 1)
					+ '"></span>'
					+ '<div class="info">'
					+ '   <h5>' + places.place_name + '</h5>';

			if (places.road_address_name) {
				itemStr += '    <span>' + places.road_address_name + '</span>'
						+ '   <span class="jibun gray">' + places.address_name
						+ '</span>';
			} else {
				itemStr += '    <span>' + places.address_name + '</span>';
			}

			itemStr += '  <span class="tel">' + places.phone + '</span>'
					+ '</div>';

			el.innerHTML = itemStr;
			el.className = 'item';

			return el;
		}

		function addMarker(position, idx, title) {
			var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', imageSize = new kakao.maps.Size(
					36, 37), imgOptions = {
				spriteSize : new kakao.maps.Size(36, 691),
				spriteOrigin : new kakao.maps.Point(0, (idx * 46) + 10),
				offset : new kakao.maps.Point(13, 37)
			}, markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize,
					imgOptions), marker = new kakao.maps.Marker({
				position : position,
				image : markerImage
			});

			marker.setMap(map);
			markers.push(marker);

			return marker;
		}

		function removeMarker() {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers = [];
		}

		function displayPagination(pagination) {
			var paginationEl = document.getElementById('pagination'), fragment = document
					.createDocumentFragment(), i;

			while (paginationEl.hasChildNodes()) {
				paginationEl.removeChild(paginationEl.lastChild);
			}

			for (i = 1; i <= pagination.last; i++) {
				var el = document.createElement('a');
				el.href = "#";
				el.innerHTML = i;

				if (i === pagination.current) {
					el.className = 'on';
				} else {
					el.onclick = (function(i) {
						return function() {
							pagination.gotoPage(i);
						}
					})(i);
				}

				fragment.appendChild(el);
			}
			paginationEl.appendChild(fragment);
		}

		function displayInfowindow(marker, title) {
			var content = '<div style="padding:5px;z-index:1;">' + title
					+ '</div>';

			infowindow.setContent(content);
			infowindow.open(map, marker);
		}

		function removeAllChildNods(el) {
			while (el.hasChildNodes()) {
				el.removeChild(el.lastChild);
			}
		}
	</script>
	
</body>
</html>