const gulp = require('gulp');
const concat = require('gulp-concat');
const minificss = require('gulp-minify-css');


gulp.task('default', function(){
	return gulp.src('./src/css/*.css')
		.pipe(minificss())
		.pipe(concat('build.css'))
		.pipe(gulp.dest('./dist/'));
});


gulp.task('default');