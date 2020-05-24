package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Comment;
import dto.CommentDTO;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mappings({@Mapping(source = "product.productId", target = "productId"),
            @Mapping(source = "restaurant.restaurantId", target = "restaurantId"),
            @Mapping(source = "client.clientId", target = "clientId")})
    CommentDTO commentToCommentDTO(Comment comment);

    @Mappings({@Mapping(source = "productId", target = "product.productId"),
            @Mapping(source = "restaurantId", target = "restaurant.restaurantId"),
            @Mapping(source = "clientId", target = "client.clientId")})
    @Mapping(source = "courierStatus", target = "courierStatus")
    Comment commentDTOToComment(CommentDTO commentDTO);
}
