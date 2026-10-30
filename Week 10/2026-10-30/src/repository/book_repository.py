import json
from pathlib import Path

from domain.book import Book, BookDict

from repository.book_repository_protocol import BookRepositoryProtocol


class BookRepository(BookRepositoryProtocol):
    FILE_PATH: str = "books.json"

    def add_book(self, book: Book) -> str:
        books = self.get_all_books()
        books.append(book)
        with open(BookRepository.FILE_PATH, "w", encoding="utf-8") as f:
            data: list[BookDict] = [Book.to_dict(x) for x in books]
            json.dump(data, f, indent=4)
        return book.book_id

    def get_all_books(self) -> list[Book]:
        file = Path(BookRepository.FILE_PATH)

        if not file.is_file():
            file.touch(exist_ok=True)
            with open(BookRepository.FILE_PATH, "w") as f:
                json.dump([], f, indent=4)

        with open(BookRepository.FILE_PATH, "r", encoding="utf-8") as f:
            data: list[BookDict] = json.load(f)
            return [Book.from_dict(x) for x in data]
