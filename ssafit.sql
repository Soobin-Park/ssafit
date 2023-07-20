DROP DATABASE IF EXISTS ssafit;
CREATE DATABASE IF NOT EXISTS ssafit;
use ssafit;

-- 임의로 데이터들 생성하였음

-- -----------------------------------------------------
-- Table `video` - 영상
-- -----------------------------------------------------
DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
    `id` VARCHAR(30) NOT NULL, -- 영상 아이디
    `title` VARCHAR(200) NOT NULL, -- 영상 제목
    `category` VARCHAR(20) NOT NULL, -- 종목
    `viewCnt` INT NOT NULL DEFAULT 0, -- 영상 조회수
    `rating_avg` decimal(2, 1) DEFAULT 0, -- 별점 평균
    `part` VARCHAR(30) NOT NULL, -- 부위
    PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO video (id, title, category, viewCnt, part)
VALUES
('gMaB-fG4u4g', '전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]', '홈트', 13162589, '전신'),
('ECu-P8IqgHU', '온 몸의 독소를 다 빼주는 전신 스트레칭', '스트레칭', 2249423, '전신'),
('ZDIIg4kvY-c', '팔뚝살 폭파 운동', '홈트', 5186292, '상체'),
('rQ0oR6_gXdU', '부드러운 자유형 스트로크 꿀팁(자유형 물잡기, 자유형 타이밍)', '수영', 109154, '전신'),
('EOJa7MqnVrs', '자기 전에 하면 딱 좋은 요가 | 숙면을 위한 자기전 스트레칭, 자기전 명상, 침대 요가 스트레칭', '요가', 12477, '전신'),
('KoMSUX2NQ_0', '[이형택의 레전드 레슨] 왼손잡이 포핸드 마스터!!!(포핸드 파워업!!!)', '테니스', 23877, '상체'),
('NlMjP_uaIW8', '한번만 따라 해도 시원함에 중독되는 폼롤러 마사지!! (근막이완 마사지, 폼롤러운동)ㅣ다노티비', '스트레칭', 3745455, '하체');
commit;
SELECT * FROM video;
-- -----------------------------------------------------
-- Table `user` - 사용자
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `user` (
  `id` VARCHAR(20) NOT NULL, -- 사용자 아이디
  `password` VARCHAR(200) NOT NULL, -- 비밀번호
  `name` VARCHAR(20) NOT NULL, -- 이름
  `nickName` VARCHAR(20) NOT NULL UNIQUE KEY, -- 닉네임
  `email` VARCHAR(50) NOT NULL, -- 이메일
  `user_rank` INT NOT NULL DEFAULT 1, -- 등급 - 기존회원은 1, 관리자는 2
  `address` VARCHAR(100) NOT NULL, -- 주소
  `img` VARCHAR(50) DEFAULT NULL, -- 이미지 - 사이트에서 제공하는 이미지 이름
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

INSERT INTO user (id, password, name, nickName, email, address, img)
VALUES
('ssafy', '1234', '김싸피', '김아무개', 'ssafy@ssafy.com', '서울 강남구 테헤란로 212', 'avatar1'),
('jiwon', '123456', '지원', '이지', 'jiwon@ssafy.com', '서울 강남구 테헤란로 208', 'avatar2'),
('soobin', '7890', '수빈', '민트', 'soobin@ssafy.com', '서울 강남구 테헤란로 216', 'avatar3'),
('hello', '1234', '박안녕', '헬로', 'hello@ssafy.com', '서울 강남구 테헤란로 152', 'avatar4'),
('happy', '5678', '최행복', '햅삐', 'happy@ssafy.com', '서울 강남구 언주로 425', 'avatar5'),
('coffee', '0987', '이커피', '카페인실허', 'cf0101@ssafy.com', '서울 강남구 논현로85길 11', 'avatar6'),
('dukkbokki', 'bokkibokki', '덕복희', '복친놈', 'bkbk@ssafy.com', '서울 강남구 언주로81길 19', 'avatar7'),
('nangnang11', '121212', '오냥냥', '냥냥이', 'nang11@ssafy.com', '서울 강남구 언주로87길 11', 'avatar8');
commit;
SELECT * FROM user;
 
 
-- -----------------------------------------------------
-- Table `gym` - 헬스장
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym`;

CREATE TABLE IF NOT EXISTS `gym` (
	`id` INT NOT NULL AUTO_INCREMENT, -- 헬스장 아이디
    `name` VARCHAR(40) NOT NULL, -- 헬스장 이름
    `address` VARCHAR(100) NOT NULL, -- 주소
    `phoneNum` VARCHAR(20), -- 전화번호
    `hours` VARCHAR(40), -- 영업 시간
    `rating_avg` decimal(2, 1) DEFAULT 0, -- 별점 평균
    `reviewCnt` INT DEFAULT 0, -- 리뷰 개수
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

INSERT INTO gym (name, address, phoneNum, hours)
VALUES
('싸피 헬스장', '서울 강남구 논현로86길 12', '02-1111-2222', '월~금 00:00~24:00'),
('역삼 헬스장', '서울 강남구 테헤란로 143', '02-3333-4444', '월~금 00:00~24:00'),
('당신의 핏', '서울 강남구 테헤란로27길 40', '02-5555-6666', '월~금 00:00~24:00, 토 09:00~18:00'),
('헬친 모여', '서울 강남구 논현로 516', '02-0101-2323', '월~금 06:00~00:00, 토,일 09:00~18:00'),
('야간 헬스장', '서울 강남구 언주로87길 23', '02-0987-1234', '연중 18:00~06:00'),
('운동해라', '서울 강남구 언주로85길 23-11', '02-1212-3434', '연중 00:00~24:00');
commit;
SELECT * FROM gym;


-- -----------------------------------------------------
-- Table `video_review` - 영상 리뷰
-- -----------------------------------------------------
DROP TABLE IF EXISTS `video_review`;

CREATE TABLE `video_review` (
	`review_id` INT NOT NULL AUTO_INCREMENT, -- 리뷰 아이디
    `video_id` VARCHAR(30) NOT NULL, -- 영상 아이디
    `content` VARCHAR(400) NULL, -- 리뷰 내용
    `rating` decimal(2, 1) NOT NULL DEFAULT 0, -- 별점
    `writer` VARCHAR(20) NOT NULL, -- 작성자
    `createdAt` TIMESTAMP DEFAULT now(), -- 작성 날짜
    PRIMARY KEY (`review_id`),
    CONSTRAINT `video_review_id_fk` FOREIGN KEY(`video_id`) REFERENCES `video` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    -- 영상 아이디 연결 - video에서 삭제 시 반영
    CONSTRAINT `video_review_nick_fk` FOREIGN KEY(`writer`) REFERENCES `user` (`nickname`) ON UPDATE CASCADE ON DELETE CASCADE
    -- 사용자 닉네임 연결 - user에서 수정 삭제 시 반영
) ENGINE=InnoDB;

INSERT INTO video_review (video_id, content, rating, writer)
VALUES
('gMaB-fG4u4g', '최고입니다', 3.0, '이지'),
('gMaB-fG4u4g', '효과 최고!', 5.0, '햅삐'),
('gMaB-fG4u4g', '괜찮네요', 3.0, '헬로'),
('ZDIIg4kvY-c', '정말 힘들어요', 4.0, '김아무개'),
('ZDIIg4kvY-c', '눈물나요', 5.0, '카페인실허'),
('ZDIIg4kvY-c', '그냥 그럼ㅋㅋ', 2.0, '복친놈'),
('rQ0oR6_gXdU', '도움이 많이 됐어요', 5.0, '민트'),
('rQ0oR6_gXdU', '운동은 보는게 최고지', 3.0, '냥냥이'),
('rQ0oR6_gXdU', '잼따', 5.0, '햅삐'),
('ECu-P8IqgHU', '운동하셔야 하는 분들 운동 하셔야 합니다', 4.0, '김아무개'),
('ECu-P8IqgHU', '무슨 말을 하냐', 2.0, '복친놈'),
('ECu-P8IqgHU', '아 쓸거 떨어짐', 3.0, '이지'),
('NlMjP_uaIW8', '뽐롤러뽐롤러', 2.0, '김아무개'),
('NlMjP_uaIW8', '이정도면 됐다', 4.0, '민트');
commit;
SELECT * FROM video_review;


-- -----------------------------------------------------
-- Table `video_mark` - 영상 찜
-- -----------------------------------------------------
DROP TABLE IF EXISTS `video_mark`;

CREATE TABLE IF NOT EXISTS `video_mark` (
	`id` INT NOT NULL AUTO_INCREMENT, -- 아이디
    `user_id` VARCHAR(20) NOT NULL, -- 사용자 아이디
    `video_id` VARCHAR(30) NOT NULL, -- 영상 아이디
    PRIMARY KEY (`id`),
    CONSTRAINT `video_mark_user_fk` FOREIGN KEY(`user_id`) REFERENCES `user` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    -- 사용자 아이디 연결 - user에서 삭제 시 반영
    CONSTRAINT `video_mark_id_fk` FOREIGN KEY(`video_id`) REFERENCES `video` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE
    -- 비디오 아이디 연결 - video에서 삭제시 반영
) ENGINE = InnoDB;
SELECT * FROM video_mark;


-- -----------------------------------------------------
-- Table `gym_review` - 헬스장 리뷰
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym_review`;

CREATE TABLE IF NOT EXISTS `gym_review` (
	`review_id` INT NOT NULL AUTO_INCREMENT, -- 리뷰 아이디
    `gym_id` INT NOT NULL, -- 헬스장 아이디
    `content` VARCHAR(400) NULL, -- 리뷰 내용
    `rating` decimal(2, 1) NOT NULL DEFAULT 0, -- 별점
    `writer` VARCHAR(20) NOT NULL, -- 작성자
    `createdAt` TIMESTAMP DEFAULT now(), -- 작성 날짜
    PRIMARY KEY (`review_id`),
    CONSTRAINT `gym_review_id_fk` FOREIGN KEY(`gym_id`) REFERENCES `gym` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    -- 헬스장 아이디 연결 - gym에서 삭제 시 반영
    CONSTRAINT `gym_review_nick_fk` FOREIGN KEY(`writer`) REFERENCES `user` (`nickname`) ON UPDATE CASCADE ON DELETE CASCADE
    -- 사용자 닉네임 연결 - user에서 수정 삭제 시 반영
) ENGINE = InnoDB;

INSERT INTO gym_review (gym_id, content, rating, writer)
VALUES
('1', '깨끗해요', 3, '이지'),
('1', '시설 좋네요', 5, '민트'),
('1', '위치도 좋고 깔끔합니다', 5, '김아무개'),
('1', '굳', 5, '햅삐'),
('1', '엉', 2, '헬로'),
('2', '좋네요', 4, '이지'),
('2', '트레이너들이 친절합니다', 5, '김아무개'),
('2', '끼릿', 3, '카페인실허'),
('3', '주말에도 해서 좋습니다', 5, '이지'),
('3', 'ㅋㅋ', 1, '김아무개'),
('3', 'ㅋㅋ', 2, '민트'),
('3', 'ㅋㅋ', 4, '복친놈'),
('4', 'ㅎㅎ', 4, '햅삐'),
('4', 'ㅎㅎ', 2, '냥냥이'),
('5', 'ㅎㅎ', 3, '햅삐'),
('6', 'ㅎㅎ', 1, '카페인실허');
commit;
SELECT * FROM gym_review;


-- -----------------------------------------------------
-- Table `board` - 게시글
-- -----------------------------------------------------
DROP TABLE IF EXISTS `board`;

CREATE TABLE IF NOT EXISTS `board` (
	`id` INT NOT NULL AUTO_INCREMENT, -- 게시글 아이디
    `title` VARCHAR(100) NOT NULL, -- 제목
    `content` TEXT NOT NULL, -- 내용
    `writer` VARCHAR(20) NOT NULL, -- 작성자
    `viewCnt` INT DEFAULT 0, -- 조회수
    `createdAt` TIMESTAMP DEFAULT now(), -- 작성 날짜
    `commentCnt` INT DEFAULT 0, -- 댓글 수
    PRIMARY KEY (`id`),
    CONSTRAINT `board_user_fk` FOREIGN KEY(`writer`) REFERENCES `user` (`nickname`) ON UPDATE CASCADE ON DELETE CASCADE
    -- 사용자 닉네임 연결 - user에서 수정 삭제 시 반영
) ENGINE = InnoDB;

INSERT INTO board (title, content, writer)
VALUES
('안녕하세요', '반갑습니다', '이지'),
('오늘 가입했어요', '잘부탁드립니다', '민트'),
('어쩌구', '저쩌구', '김아무개'),
('어쩌구', '저쩌구', '냥냥이');
commit;
SELECT * FROM board;


-- -----------------------------------------------------
-- Table `comment` - 댓글
-- -----------------------------------------------------
DROP TABLE IF EXISTS `comment`;

CREATE TABLE IF NOT EXISTS `comment` (
	`comment_id` INT NOT NULL AUTO_INCREMENT, -- 댓글 아이디
    `board_id` INT NOT NULL, -- 게시글 아이디
    `content` VARCHAR(400) NOT NULL, -- 내용
    `writer` VARCHAR(20) NOT NULL, -- 작성자
    `createdAt` TIMESTAMP DEFAULT now(), -- 작성 날짜
    PRIMARY KEY (`comment_id`),
    CONSTRAINT `comment_board_fk` FOREIGN KEY(`board_id`) REFERENCES `board` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    -- 게시글 아이디 연결 - board에서 삭제 시 반영
    CONSTRAINT `comment_user_fk` FOREIGN KEY(`writer`) REFERENCES `user` (`nickname`) ON UPDATE CASCADE ON DELETE CASCADE
    -- 사용자 닉네임 연결 - user에서 수정 삭제 시 반영
) ENGINE = InnoDB;

INSERT INTO comment (board_id, writer, content)
VALUES
(1, '김아무개', '저도 반가워요~!'),
(1, '민트', '환영합니다'),
(2, '이지', '네~');
commit;

set sql_safe_updates=0;
-- 리뷰 수 반영하기 위해 작성함.
UPDATE gym
SET reviewCnt = (SELECT COUNT(review_id) FROM gym_review WHERE gym.id = gym_review.gym_id);
commit;
-- 헬스장 별점 평균 반영하기 위해 작성함.
UPDATE gym
SET rating_avg = (SELECT AVG(rating) FROM gym_review WHERE gym.id = gym_review.gym_id);
commit;
-- 영상 별점 평균 반영하기 위해 작성함.
UPDATE video
SET rating_avg = (SELECT AVG(rating) FROM video_review WHERE video.id = video_review.video_id);
commit;
-- 댓글 수 반영하기 위해 작성함.
UPDATE board
SET commentCnt = (SELECT COUNT(comment_id) FROM comment WHERE board.id = comment.board_id);
commit;


SELECT * FROM comment;


SELECT v.id, v.title, v.category, v.viewCnt, v.rating_avg, v.part
FROM video v
INNER JOIN video_mark vm ON v.id = vm.video_id
WHERE vm.user_id = 'ssafy';

SELECT u.img
FROM user u
INNER JOIN board b ON u.nickname = b.writer
WHERE b.id=1;

SELECT u.img
FROM user u
INNER JOIN comment c ON u.nickname = c.writer
WHERE c.comment_id=1;
