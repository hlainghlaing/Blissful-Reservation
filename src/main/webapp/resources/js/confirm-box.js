function showUserConfirmation(userId) {
	document.getElementById("confirmationUserModal").style.display = "block";
	document.getElementById("deleteUser").href = "delete-user?id=" + userId;
}

function hideUserConfirmation() {
	document.getElementById("confirmationUserModal").style.display = "none";
}

function showBookingConfirmation(bookingId) {
	document.getElementById("confirmationBookingModal").style.display = "block";
	document.getElementById("reject").href = "reject?id=" + bookingId;
}

function hideBookingConfirmation() {
	document.getElementById("confirmationBookingModal").style.display = "none";
}

function showRoomConfirmation(roomId) {
	document.getElementById("confirmationRoomModal").style.display = "block";
	document.getElementById("deleteRoom").href = "deleteroom?id=" + roomId;
}

function hideRoomConfirmation() {
	document.getElementById("confirmationRoomModal").style.display = "none";
}


function showHotelConfirmation(hotelId) {
	document.getElementById("confirmationHotelModal").style.display = "block";
	document.getElementById("deleteHotel").href = "delete-hotel?id=" + hotelId;
}

function hideConfirmation() {
	document.getElementById("confirmationHotelModal").style.display = "none";
}