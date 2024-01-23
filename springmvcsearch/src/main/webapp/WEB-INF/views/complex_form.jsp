<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<title>Complex Form</title>
</head>
<body class="" style="background: #e2e2e2;">

	<div class="container mt-4">

		<div class="row">

			<div class="col-md-8 offset-md-2">

				<div class="card">

					<div class="card-body">

						<h3 class="text-center">Complex Form</h3>

						<div class="alert alert-danger" role="alert">

							<form:errors path="student.*" />

						</div>

						<form action="handleform" method="post">

							<div class="form-group">
								<label for="exampleInputEmail1">Your name</label> <input
									name="name" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter Name"> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									name with anyone else</small>
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Your id</label> <input name="id"
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Id">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Your DOB</label> <input
									name="date" type="date" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="dd/mm/yyyy">
							</div>

							<div class="form-group">
								<label>Select Courses</label> <select name="courses"
									class="form-control" id="exampleFormControlSelect1" multiple>
									<option>Java</option>
									<option>Python</option>
									<option>C++</option>
									<option>Django</option>
									<option>Spring Framework</option>
								</select>
							</div>

							<div class="form-group">
								<span class="mr-3">Select Gender</span>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="inlineRadio1" value="male"> <label
										class="form-check-label" for="inlineRadio1">Male</label>
								</div>

								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="gender"
										id="inlineRadio2" value="male"> <label
										class="form-check-label" for="inlineRadio2">Female</label>
								</div>

							</div>

							<div class="form-group">
								<label>Select Type</label> <select class="form-control"
									name="type">
									<option value="oldstudent">Old Student</option>
									<option value="normalstudent">Normal Student</option>
								</select>
							</div>

							<div class="card">

								<div class="card-body">

									<p>Your address</p>

									<div class="form-group">
										<input name="address.street" type="text" class="form-control"
											placeholder="Enter street" />
									</div>

									<div class="form-group">
										<input name="address.city" type="text" class="form-control"
											placeholder="Enter city" />
									</div>

								</div>

							</div>

							<div class="container text-center">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>