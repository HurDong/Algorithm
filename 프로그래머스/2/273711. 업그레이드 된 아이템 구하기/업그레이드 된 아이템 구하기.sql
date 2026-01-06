-- 이중조인보다는 exists로 부모 item 끼리 조건을 걸어 필터링.
select ii.item_id, ii.item_name, ii.rarity from item_info ii join item_tree it on ii.item_id = it.item_id where  exists (
    select * from item_info ii2 where ii2.rarity = 'RARE' and ii2.item_id = it.parent_item_id
)
order by item_id desc;