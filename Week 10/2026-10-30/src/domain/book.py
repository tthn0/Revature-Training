from __future__ import annotations

import uuid
from dataclasses import dataclass, field
from typing import TypedDict


class BookDict(TypedDict):
    title: str
    author: str | None
    book_id: str


@dataclass
class Book:
    title: str
    author: str | None = None
    book_id: str = field(default_factory=lambda: str(uuid.uuid7()))

    def to_dict(self) -> BookDict:
        return {"book_id": self.book_id, "title": self.title, "author": self.author}

    @classmethod
    def from_dict(cls, data: BookDict) -> Book:
        return cls(**data)
