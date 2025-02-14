# coding: utf-8

"""
    OpenAPI Petstore

    This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\  # noqa: E501

    The version of the OpenAPI document: 1.0.0
    Generated by: https://openapi-generator.tech
"""

import re  # noqa: F401
import sys  # noqa: F401
import typing  # noqa: F401

from frozendict import frozendict  # noqa: F401

from decimal import Decimal  # noqa: F401
from datetime import date, datetime  # noqa: F401
from frozendict import frozendict  # noqa: F401

from petstore_api.schemas import (  # noqa: F401
    AnyTypeSchema,
    ComposedSchema,
    DictSchema,
    ListSchema,
    StrSchema,
    IntSchema,
    Int32Schema,
    Int64Schema,
    Float32Schema,
    Float64Schema,
    NumberSchema,
    DateSchema,
    DateTimeSchema,
    BoolSchema,
    BinarySchema,
    NoneSchema,
    none_type,
    InstantiationMetadata,
    Unset,
    unset,
    ComposedBase,
    ListBase,
    DictBase,
    NoneBase,
    StrBase,
    IntBase,
    NumberBase,
    DateBase,
    DateTimeBase,
    BoolBase,
    BinaryBase,
    Schema,
    _SchemaValidator,
    _SchemaTypeChecker,
    _SchemaEnumMaker
)


class Animal(
    DictSchema
):
    """NOTE: This class is auto generated by OpenAPI Generator.
    Ref: https://openapi-generator.tech

    Do not edit the class manually.

    Attributes:
    className (str,): 
    color (str,): 
    _additional_properties (Schema): the definition used for additional properties
        that are not defined in _properties
    _discriminator(cls) -> dict: the key is the required discriminator propertyName
        the value is a dict mapping from a string name to the corresponding Schema class
    """
    _required_property_names = set((
        'className',
    ))
    className = StrSchema
    color = StrSchema

    @classmethod
    @property
    def _discriminator(cls):
        return {
            'className': {
                'Cat': Cat,
                'Dog': Dog,
            }
        }


    def __new__(
        cls,
        *args: typing.Union[dict, frozendict, ],
        className: className,
        color: typing.Union[color, Unset] = unset,
        _instantiation_metadata: typing.Optional[InstantiationMetadata] = None,
        **kwargs: typing.Type[Schema],
    ):
        return super().__new__(
            cls,
            *args,
            className=className,
            color=color,
            _instantiation_metadata=_instantiation_metadata,
            **kwargs,
        )

from petstore_api.model.cat import Cat
from petstore_api.model.dog import Dog
