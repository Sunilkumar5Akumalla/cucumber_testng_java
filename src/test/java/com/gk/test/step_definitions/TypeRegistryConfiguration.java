package com.gk.test.step_definitions;

import com.gk.test.models.api.ItemModel;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;
import java.util.Map;

public class TypeRegistryConfiguration {

    public Locale locale() {
        return Locale.ENGLISH;
    }

    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(ItemModel.class,
                new TableEntryTransformer<ItemModel>() {

                    @Override
                    public ItemModel transform(Map<String, String> entry)
                            throws Throwable {
                        ItemModel itemModel = new ItemModel();
                        itemModel.setId(Integer.parseInt(entry.get("id")));
                        itemModel.setUserId(Integer.parseInt(entry.get("userId")));
                        itemModel.setTitle(entry.get("title"));
                        itemModel.setBody(entry.get("body"));
                        return itemModel;
                    }


                }));
    }
}
