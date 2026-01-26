INSERT INTO game_rule (id, name, description, created_at, updated_at) VALUES 
('fizz', 'フィズ', '出た数字が3の倍数の時に加点する。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('buzz', 'バズ', '出た数字が5の倍数の時に加点する。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('hoge', 'ホゲ', '出た数字が7の倍数の時に加点する。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('prime', '素数', '出た数字が素数の時に加点する', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('multiple-synergy', '倍数シナジー', '出た数字に対して、二つの倍数ルールが適用された場合、全体のスコアが増える。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('digit-sum', '桁和コンボ', '出た数字の各桁の数字を足した合計に対しても倍数ルールが適用された場合、適用された数だけ全体のスコアが増える。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);