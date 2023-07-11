package test.com.project.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MongoMemberDAOimpl implements MongoMemberDAO {

	@Autowired
	MongoCollection<Document> member;

	@Override
	public List<MongoMemberVO> findAll() {
		log.info("findAll()....");
		List<MongoMemberVO> list = new ArrayList<MongoMemberVO>();

		Bson sort = new Document("_id", -1);//순정렬:1, 역정렬:-1
		
		FindIterable<Document> docs = member.find().sort(sort);
		for (Document doc : docs) {
			MongoMemberVO vo = new MongoMemberVO();
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}
	

	@Override
	public int insert(MongoMemberVO vo) {
		log.info("insert()....{}", vo);
		int flag = 0;

		try {
			Document doc = new Document();
			doc.put("num", vo.getNum());
			doc.put("id", vo.getId());
			doc.put("pw", vo.getPw());
			doc.put("name", vo.getName());
			doc.put("tel", vo.getTel());
			member.insertOne(doc);
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public MongoMemberVO findOne(MongoMemberVO vo) {
		log.info("findOne()....{}", vo);

		MongoMemberVO vo2 = new MongoMemberVO();
//		Bson filters = Filters.or(
//									Filters.eq("num", vo.getNum()),
//									Filters.eq("_id", 
//											vo.getMid()==null?"":new ObjectId(vo.getMid()))
//					   ); 
		Bson filter = new Document("_id",vo.getMid()==null?"":new ObjectId(vo.getMid()));

		FindIterable<Document> docs = member.find(filter);

		for (Document doc : docs) {
			vo2.setMid(doc.get("_id").toString());
			vo2.set_id(doc.get("_id").toString());
			vo2.setNum(doc.getInteger("num", 0));
			vo2.setId(doc.getString("id"));
			vo2.setPw(doc.getString("pw"));
			vo2.setName(doc.getString("name"));
			vo2.setTel(doc.getString("tel"));
		}

		return vo2;
	}


	@Override
	public List<MongoMemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()....{},{}",searchKey,searchWord);
		List<MongoMemberVO> list = new ArrayList<MongoMemberVO>();

		Bson sort = new Document("num", -1);//순정렬:1, 역정렬:-1
		
		//find({name:/im/}) where name like '%im%'
		Bson filter = Filters.regex(searchKey, searchWord);
		
		FindIterable<Document> docs = member.find(filter).sort(sort);
		for (Document doc : docs) {
			MongoMemberVO vo = new MongoMemberVO();
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}


	@Override
	public List<MongoMemberVO> searchList2(int num1, int num2) {
		log.info("searchList2()...{},{}",num1,num2);
		List<MongoMemberVO> list = new ArrayList<MongoMemberVO>();

		Bson sort = new Document("num", -1);//순정렬:1, 역정렬:-1
		
		//find({$or:[{num:3},{num:6}]})  where num=3 or num=6
//		Bson filter = Filters.or(Filters.eq("num", num1), Filters.eq("num", num2));
		
		//find({num:{$in:[3,6]}})   where num in(3,6)  
//		Bson filter = Filters.in("num",num1,num2);
		
		//find({$and:[{num:3},{num:6}]})  where num>=3 and num<=6
		//find({num:{$gte:3,$lte:6}})
		Bson filter = Filters.and(Filters.gte("num", num1), Filters.lte("num", num2));
		
		FindIterable<Document> docs = member.find(filter).sort(sort);
		for (Document doc : docs) {
			MongoMemberVO vo = new MongoMemberVO();
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}
	
	@Override
	public List<Document> searchList3(int num1, int num2) {
		log.info("searchList3()...{},{}",num1,num2);
		List<Document> list = new ArrayList<Document>();
		
		Bson sort = new Document("num", -1);//순정렬:1, 역정렬:-1
		
		Bson filter = Filters.and(Filters.gte("num", num1), Filters.lte("num", num2));
		
		FindIterable<Document> docs = member.find(filter).sort(sort);
		for (Document doc : docs) {
			log.info("{}",doc);
			list.add(doc);
		}
		
		return list;
	}


	@Override
	public List<MongoMemberVO> findAll2(int page, int limit) {
		log.info("findAll2()...{},{}",page,limit);
		List<MongoMemberVO> list = new ArrayList<MongoMemberVO>();

		Bson sort = new Document("num", -1);//순정렬:1, 역정렬:-1
		
		FindIterable<Document> docs = member.find().sort(sort).skip((page-1)*limit).limit(limit);
		for (Document doc : docs) {
			MongoMemberVO vo = new MongoMemberVO();
			vo.set_id(doc.get("_id").toString());
			vo.setNum(doc.getInteger("num", 0));
			vo.setId(doc.getString("id"));
			vo.setPw(doc.getString("pw"));
			vo.setName(doc.getString("name"));
			vo.setTel(doc.getString("tel"));
			list.add(vo);
		}

		return list;
	}


	@Override
	public int update(MongoMemberVO vo) {
		log.info("update()....{}", vo);
		int flag = 0;

		try {
//			Bson filter = new Document("num",vo.getNum());
			Bson filter = new Document("_id",vo.getMid()==null?"":new ObjectId(vo.getMid()));
			
			Document up_doc = new Document("id", vo.getId());
			up_doc.append("pw", vo.getPw());
			up_doc.append("name", vo.getName());
			up_doc.append("tel", vo.getTel());
			
			Bson bsons = new Document("$set", up_doc);
			
			UpdateResult result =  member.updateOne(filter,bsons);
			log.info("{}",result);
			flag = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}


	@Override
	public int delete(MongoMemberVO vo) {
		log.info("delete()....{}", vo);
		int flag = 0;
		
		try {
//			Bson filter = new Document("num",vo.getNum());
			Bson filter = new Document("_id",vo.getMid()==null?"":new ObjectId(vo.getMid()));
			
			DeleteResult result =  member.deleteOne(filter);
			
			log.info("getDeletedCount():{}",result.getDeletedCount());
			
			flag = (int)result.getDeletedCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}


	@Override
	public MongoMemberVO findOne_idCheck(MongoMemberVO vo) {
		log.info("findOne_idCheck()....{}", vo);

		MongoMemberVO vo2 = new MongoMemberVO();
		Bson filter = new Document("id",vo.getId());
		FindIterable<Document> docs = member.find(filter);

		for (Document doc : docs) {
			vo2.setId(doc.getString("id"));
		}

		return vo2;
	}


	@Override
	public List<Document> findAll_doc() {
		log.info("findAll()....");
		List<Document> list = new ArrayList<Document>();

		Bson sort = new Document("_id", -1);//순정렬:1, 역정렬:-1
		
		FindIterable<Document> docs = member.find().sort(sort);
		for (Document doc : docs) {
			list.add(doc);
		}

		return list;
	}

}
